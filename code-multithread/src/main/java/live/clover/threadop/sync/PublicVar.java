package live.clover.threadop.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 */
public class PublicVar {
    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            TimeUnit.SECONDS.sleep(3);
            this.password = password;
            System.out.println("setValue method thread name = "
                    + Thread.currentThread().getName()
                    + " username=" + username
                    + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue method thread name = "
                + Thread.currentThread().getName()
                + " username=" + username
                + " password=" + password);
    }
}
