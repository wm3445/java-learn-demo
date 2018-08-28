package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wangmeng
 */
public class SocketClient {


    private String host;

    private int port;

    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public void connect() {

        try {
            Socket socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            String msg = "hello socket world！";
            outputStream.write(msg.getBytes("UTF-8"));
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient("127.0.0.1", 9000);
        socketClient.connect();
    }
}
