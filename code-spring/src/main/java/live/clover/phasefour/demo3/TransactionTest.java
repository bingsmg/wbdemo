package live.clover.phasefour.demo3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author weibb
 * @date 2023-10-12
 */
public class TransactionTest {

    JdbcTemplate jdbcTemplate = null;
    DataSource dataSource = null;

    @BeforeEach
    public void init() {
        jdbcTemplate = DataSourceUtils.jdbcTemplate;
        dataSource = DataSourceUtils.getDataSource();
    }

    @AfterEach
    public void destroy() {
        System.out.println("after: " + jdbcTemplate.queryForList("SELECT * FROM t_user"));
    }

    @Test
    public void test_connection() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM t_user");
        System.out.println(maps);
    }

    @Test
    public void test_update() {
        int updateRows = jdbcTemplate.update("INSERT INTO t_user (name) VALUE ('zhaoliu')");
        System.out.println("affected rows: " + updateRows);
    }

    @Test
    public void test1() {
        JdbcTemplate jdbcTemplate = DataSourceUtils.jdbcTemplate;
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(DataSourceUtils.getDataSource());
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            System.out.println("Before: " + jdbcTemplate.queryForList("SELECT * FROM t_user"));
            jdbcTemplate.update("INSERT INTO t_user (name) values (?)", "test-1");
            jdbcTemplate.update("INSERT INTO t_user (name) values (?)", "test-2");
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            platformTransactionManager.rollback(transactionStatus);
        }
        System.out.println("after: " + jdbcTemplate.queryForList("SELECT * FROM t_user"));
    }

    @Test
    public void test_transaction_template() {
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setTimeout(10);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager, transactionDefinition);
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                jdbcTemplate.update("INSERT INTO t_user (name) VALUES (?)", "transactionTemplate-1");
                jdbcTemplate.update("INSERT INTO t_user (name) VALUES (?)", "transactionTemplate-2");
            }
        });

        transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                return jdbcTemplate.update("INSERT INTO t_user (name) VALUES (?)", "executeWithResult-3-1");
            }
        });
    }

    @Test
    public void test_declarative_tx() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig4.class);
        context.refresh();

        UserService userService = context.getBean(UserService.class);
        userService.insertBatch("Java", "Mysql", "Maven", "Mybatis", "Docker");
        userService.userList();
    }
}
