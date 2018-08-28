package nio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangmeng
 * <p>
 * 传统BIO完成一个网络通信
 */
public class ServerIOSocket {


    private static final Logger logger = Logger.getLogger(ServerIOSocket.class);

    private ThreadPoolExecutor executor;

    private int port;

    private ServerIOSocket(int port) {
        this.port = port;
        init();
    }

    private void init() {
        ThreadFactory threadFactory = r -> new Thread("nio-thread-test-%d");
        executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), threadFactory);
        logger.info("socket server 已启动等待客户端连接！");
    }

    /**
     * 传统BIO
     *
     * @throws IOException
     */
    public void start() throws IOException {


        ServerSocket serverSocket = new ServerSocket(port);
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            logger.info("socket 已连接");
            // new Thread(new ConnectHandler(socket)).start();
            executor.submit(new ConnectHandler(socket));
        }


    }


    public static void main(String[] args) {
        try {
            ServerIOSocket nioServer = new ServerIOSocket(9000);
            nioServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
