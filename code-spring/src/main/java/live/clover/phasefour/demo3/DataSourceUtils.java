package live.clover.phasefour.demo3;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author weibb
 * @date 2023-10-12
 */
public class DataSourceUtils {

    public static DataSource getDataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.101.204.168:3306/clover");
        dataSource.setUsername("root");
        dataSource.setPassword("Mr.seven-7");
        return dataSource;
    }

    static JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
}
