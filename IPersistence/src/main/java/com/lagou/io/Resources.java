package com.lagou.io;

import java.io.InputStream;

public class Resources {
    public static InputStream getResouceAsStream(String path) {
        // 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
