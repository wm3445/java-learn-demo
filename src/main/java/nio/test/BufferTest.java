package nio.test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @Author: king.wm
 * @Date: 2019-02-28 16:57
 * @Version 1.0
 */
public class BufferTest {

    public static void main(String[] args) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        byte[] array = wrap.array();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-=-=-=-=-");
        System.out.println(wrap.get());
        System.out.println(wrap.get());
        System.out.println(wrap.get());
        System.out.println(wrap.get());
        System.out.println(wrap.get());
        System.out.println(wrap.get());

        wrap.flip();
        System.out.println(wrap.get());


    }
}
