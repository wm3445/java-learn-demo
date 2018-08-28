package nio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangmeng
 */
public class NIOClient {

    private static final Logger logger = Logger.getLogger(NIOClient.class);

    private InetSocketAddress inetSocketAddress;

    public NIOClient(String host, int port) {
        this.inetSocketAddress = new InetSocketAddress(host, port);


    }


    public void send(String msg) {
        try {
            SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
            socketChannel.configureBlocking(false);
            int bufferSize = 1024;
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
            socketChannel.write(ByteBuffer.wrap(msg.getBytes("UTF-8")));
            while (true) {
                byteBuffer.clear();
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0) {
                    byteBuffer.flip();
                    logger.info("Client: readBytes = " + readBytes);
                    logger.info("Client: data = " + new String(byteBuffer.array(), 0, readBytes));
                    socketChannel.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class EventHandler implements Runnable {

        @Override
        public void run() {
            logger.info("run.....");
            NIOClient nioClient = new NIOClient("127.0.0.1", 9000);
            nioClient.send("hello world   " + Thread.currentThread().getName() + " <-=-=-=-");
        }
    }

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = Thread::new;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(new EventHandler());
        }
        executor.shutdown();

    }
}
