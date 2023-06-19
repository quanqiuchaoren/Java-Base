package com.lhy.java.base.nio_1_0;

import com.lhy.java.base.nio_1_0.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileChannelWriteTest {
    @Test
    void write() throws IOException {
        String filePathStr = FileUtil.getFilePathStr("fileChannelWrite.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePathStr);
             FileChannel fileChannel = fileOutputStream.getChannel();
        ) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(8);
            // 一个字母是一个byte
            String str = "write first line \r\n write second line";
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            System.out.println(Arrays.toString(bytes));
            // 输出：[119, 114, 105, 116, 101, 32, 102, 105, 114, 115, 116, 32, 108, 105, 110, 101, 13, 10, 32, 119, 114, 105, 116, 101, 32, 115, 101, 99, 111, 110, 100, 32, 108, 105, 110, 101]
            // 一个字母，一个byte

            System.out.println(Arrays.toString(bytes));
            for (int i = 0; i < bytes.length; ) {
                if (byteBuffer.hasRemaining()) {
                    byteBuffer.put(bytes[i++]);
                } else {
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        fileChannel.write(byteBuffer);
                    }
                    byteBuffer.clear();
                }
            }
        }
    }
}
