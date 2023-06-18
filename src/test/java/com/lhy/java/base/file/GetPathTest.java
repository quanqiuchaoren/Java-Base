package com.lhy.java.base.file;

import com.lhy.java.base.nio_1_0.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class GetPathTest {
    @Test
    void hello() throws IOException {
        // 1.获取当前文件所在的路径
        // 编译后字节码文件所在路径
        // /D:/code/Java-Base/target/test-classes/com/lhy/java/base/nio_1_0/
        System.out.println(this.getClass().getResource("").getPath());
        // 2.获取再 target 下 classpath 路径
        // 编译后字节码文件的根路径
        // /D:/code/Java-Base/target/test-classes/
        System.out.println(this.getClass().getResource("/").getPath());
        // 3.也是获取 classpath 的绝对路径
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        // 4.也是获取 classpath 的绝对路径
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
        // 5.也是获取 classpath 的绝对路径
        System.out.println(ClassLoader.getSystemResource("").getPath());
        // 6.获取当前项目路径（此方法与 7 效果相同，但是可以将路径转为标准形式，会处理“.”和“..”）
        System.out.println(new File("").getCanonicalPath());
        // 7.获取项目绝对路径（不会处理“.”和“..”）
        System.out.println(new File("").getAbsolutePath());

        /*
        輸出：
        /D:/code/Java-Base/target/test-classes/com/lhy/java/base/file/
        /D:/code/Java-Base/target/test-classes/
        /D:/code/Java-Base/target/test-classes/
        /D:/code/Java-Base/target/test-classes/
        /D:/code/Java-Base/target/test-classes/
        D:\code\Java-Base
        D:\code\Java-Base
         */
    }
}
