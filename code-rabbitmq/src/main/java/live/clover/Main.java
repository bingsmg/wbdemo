package live.clover;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author weibb
 * @date 2023-11-13
 */
public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.101.204.168");
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}