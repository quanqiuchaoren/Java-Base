package com.lhy.java.base.nio_1_0.util;

import java.io.File;

public class FileUtil {
    /**
     * 获取项目根路径下的文件的路径的字符串
     *
     * @param fileName 项目根路径下的testFile/下的文件名
     * @return 文件的绝对路径的字符串
     */
    public static String getFilePathStr(String fileName) {
        // 项目根路径：D:\code\Java-Base
        String projectBaseDirStr = new File("").getAbsolutePath();
        return projectBaseDirStr + File.separator + "testFile" + File.separator + fileName;
    }
}
