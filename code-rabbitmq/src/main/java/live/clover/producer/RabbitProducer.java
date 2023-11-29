package live.clover.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author weibb
 * @date 2023-11-29
 */
public class RabbitProducer {
    private static final String EXCHANGE_NAME = "exchange_clover";
    private static final String ROUTING_KEY = "routingkey_clover";
    private static final String QUEUE_NAME = "queue_clover";
    private static final String IP_ADDR = "47.101.204.168";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDR);
        factory.setPort(PORT);
//        factory.setUsername("admin");
//        factory.setPassword("root");

        final Connection connection = factory.newConnection();
        // Connection 可以用来创建多个 Channel，但是 Channel 不能线程共享使用。
        final Channel channel = connection.createChannel();
        // 创建一个 type=direct 持久化、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个持久化、非排他、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME,
                ROUTING_KEY,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());

        channel.close();
        connection.close();
    }
}
