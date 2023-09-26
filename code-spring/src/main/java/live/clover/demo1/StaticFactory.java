package live.clover.demo1;

/**
 * @author weibb
 * @date 2023-09-26
 */
public class StaticFactory {

    public static User getUser1(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
}
