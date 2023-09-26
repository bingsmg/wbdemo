package live.clover.demo1;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author weibb
 * @date 2023-09-26
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setId(20);
        user.setName("created by factory bean.");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
