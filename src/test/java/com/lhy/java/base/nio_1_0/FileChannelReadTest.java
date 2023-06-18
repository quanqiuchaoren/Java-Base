package com.lhy.java.base.nio_1_0;

import com.lhy.java.base.nio_1_0.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelReadTest {
    /**
     * 从FileChannel读取数据
     */
    @Test
    void hello2() throws IOException {
        /*
        文件中的内容为：
        first line
        second line
         */
        String filePathStr = FileUtil.getFilePathStr("fileChannel.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePathStr, "rw");
        ) {
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(8);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip(); // 读写切换时，要调用flip()方法。
                System.out.println(StandardCharsets.UTF_8.decode(byteBuffer));
                byteBuffer.clear(); // 需要清除之前读入的数据，否则下一次获取byteBuffer中的数据时，一直是第一次读入的数据。
            }
        }
        /*
         * 输出：
            first li
            ne
            seco
            nd line
         */
    }
}
