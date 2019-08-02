package nio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

/**
 * @author wangmeng
 */
public class NIOClient {

    private static final Logger logger = Logger.getLogger(NIOClient.class);

    private static final CountDownLatch latch = new CountDownLatch(10);

    private InetSocketAddress inetSocketAddress;

    private SocketChannel socketChannel = null;

    private Selector selector = null;

    public NIOClient(String host, int port) {
        this.inetSocketAddress = new InetSocketAddress(port);
        init();
    }

    private void init() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(inetSocketAddress);
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            for (; ; ) {
                if (socketChannel.finishConnect()) {
                    break;
                }
            }
            System.out.println("已连接上服务器!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send(String msg) {
        try {

            int bufferSize = 256;
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
            socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
            while (true) {
                // byteBuffer.clear();
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0) {
                    byteBuffer.flip();
                    logger.info("Client: receive data = " + new String(byteBuffer.array(), 0, readBytes));
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
            NIOClient nioClient = new NIOClient("localhost", 9001);
            nioClient.send("client msg hello world   " + Thread.currentThread().getName());
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = Thread::new;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(new EventHandler());
        }
        try {
            System.out.println("等待10个子线程执行完毕...");
            latch.await();
            System.out.println("10个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

    }
}
