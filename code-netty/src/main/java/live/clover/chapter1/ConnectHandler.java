package live.clover.chapter1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author weibb
 */
public class ConnectHandler extends ChannelInboundHandlerAdapter {

    // 当一个新的连接已经被建立时，channelActive将会被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client " + ctx.channel().remoteAddress() + " connected");
    }
}
