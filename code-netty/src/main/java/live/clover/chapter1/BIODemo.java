package live.clover.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞函数 BIO(blocking I/O)或者叫(old input/output, OIO)，还可能叫(plain input/output, PIO)
 * @author weibb
 */
public class BIODemo {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) break;
            response = processRequest(request);
            out.println(response);
        }
    }

    private static String processRequest(String request) {
        return request;
    }
}
