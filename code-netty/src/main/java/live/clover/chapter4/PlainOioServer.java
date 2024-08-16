package live.clover.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 阻塞连接完全可以中等数量的并发客户端，但是随着app变得流行起来，发现它并不能很好地伸缩到支撑成千上万的并发连入连接
 * 所以你决定开始改用异步网络编程，但很快发现异步api是完全不同的，以至于你必须重写你的app
 * @author weibb
 */
public class PlainOioServer {

    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (; ; ) {
                final Socket client = socket.accept();
                System.out.println("Accepted connection from " + client);
                new Thread(() -> {
                    OutputStream out;
                    try {
                        out = client.getOutputStream();
                        out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        out.flush();
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            client.close();
                        } catch (IOException e) {
                            // ignore on close
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
