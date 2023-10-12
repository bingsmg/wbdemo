package live.clover.phasefour.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weibb
 * @date 2023-10-12
 */
@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insertBatch(String... names) {
        jdbcTemplate.update("TRUNCATE TABLE t_user");
        for (String name : names) {
            jdbcTemplate.update("INSERT INTO t_user (name) VALUES (?)", name);
        }
    }

    public void userList() {
        System.out.println(jdbcTemplate.queryForList("SELECT * FROM t_user"));
    }
}
