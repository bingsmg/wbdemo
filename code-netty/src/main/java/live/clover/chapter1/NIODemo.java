package live.clover.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * 非阻塞调用
 * @author weibb
 */
public class NIODemo {
    private static final Channel CHANNEL = new NioSocketChannel();
    public static void main(String[] args) {
        Channel channel = CHANNEL;
        ChannelFuture future = channel.connect(
                new InetSocketAddress("127.0.0.1", 25));
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                ByteBuf buffer = Unpooled.copiedBuffer(
                        "Hello", Charset.defaultCharset());
                ChannelFuture wf = future1.channel().writeAndFlush(buffer);
                //...
            } else {
                future1.cause().printStackTrace();
            }
        });

    }
}
