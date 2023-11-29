package live.clover.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author weibb
 * @date 2023-11-29
 */
public class RabbitConsumer {
    private static final String QUEUE_NAME = "queue_clover";
    private static final String IP_ADDR = "47.101.204.168";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        final Address[] addresses = {
                new Address(IP_ADDR, PORT)
        };

        final ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("admin");
//        factory.setPassword("root");

        final Connection connection = factory.newConnection(addresses);
        final Channel channel = connection.createChannel();
        // 设置客户端最多接受未被 ack 的消息个数
        channel.basicQos(64);
        channel.basicConsume(QUEUE_NAME, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
        TimeUnit.SECONDS.sleep(10);
        channel.close();
        connection.close();
    }
}
