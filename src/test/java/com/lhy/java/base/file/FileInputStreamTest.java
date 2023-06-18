package com.lhy.java.base.file;

import com.lhy.java.base.nio_1_0.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileInputStreamTest {
    @Test
    void hello2() throws IOException {
        // 获取当前项目的额根路径：
        // D:\code\Java-Base
        String filePathStr = FileUtil.getFilePathStr("fileChannel.txt");
        InputStream inputStream = new FileInputStream(new File(filePathStr));
        byte[] buffer = new byte[8];
        while (inputStream.read(buffer) != -1) {
            System.out.println(new String(buffer, StandardCharsets.UTF_8));
        }
    }
}
