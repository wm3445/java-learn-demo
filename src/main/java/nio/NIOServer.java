package nio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangmeng
 */
public class NIOServer {

    public int bufferSize = 512;

    private int port;

    private ServerHandler handler = new ServerHandler();

    private static final Logger logger = Logger.getLogger(ServerIOSocket.class);


    public NIOServer(int port) {
        this.port = port;
    }


    public void start() {

        try {
            // 生命chanel selector address
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(
                    InetAddress.getLocalHost(), port);

            socketChannel.socket().bind(inetSocketAddress);
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server started .... port:9000 等待客户端连接！");
            while (!Thread.currentThread().isInterrupted()) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        handler.handleAccept(selectionKey);
                    } else if (selectionKey.isReadable()) {
                        handler.handleRead(selectionKey);
                    } else if (selectionKey.isWritable()) {
                        handler.handleWrite(selectionKey);
                    }
                    iterator.remove();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 服务端事件处理实现类
     *
     * @author shirdrn
     */
    class ServerHandler {

        public void handleAccept(SelectionKey key) throws IOException {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            logger.info("Server: accept client socket " + socketChannel);
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_READ);
        }

        public void handleRead(SelectionKey key) throws IOException {
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
            SocketChannel socketChannel = (SocketChannel) key.channel();
            while (true) {
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0) {
                    logger.info("Server: readBytes = " + readBytes);
                    logger.info("Server: data = " + new String(byteBuffer.array(), 0, readBytes));
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    break;
                }
            }
            socketChannel.close();
        }

        public void handleWrite(SelectionKey key) throws IOException {
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.flip();
            SocketChannel socketChannel = (SocketChannel) key.channel();
            socketChannel.write(byteBuffer);
            if (byteBuffer.hasRemaining()) {
                key.interestOps(SelectionKey.OP_READ);
            }
            byteBuffer.compact();
        }
    }


    /**
     * ByteBuffer 转换 String
     *
     * @param buffer
     * @return
     */
    public static String getString(ByteBuffer buffer) {
        StringBuilder string = new StringBuilder();
        try {
            for (int i = 0; i < buffer.position(); i++) {
                string.append((char) buffer.get(i));
            }
            return string.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        NIOServer nioServer = new NIOServer(9000);
        nioServer.start();
    }

}
