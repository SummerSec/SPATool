package com.sumsec.core.ast.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


/**
 * @ClassName: JavaContent
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 15:56
 * @Version: v1.0.0
 * @Description: 读取Java文件内容
 **/
public class JavaContent {
    private static Logger log = LogManager.getLogger(JavaContent.class);

    public static String ReadJavaContent(File file) {
        String content = "";
        try {
            log.info("正在读取Java文件内容：" + file.getAbsolutePath());
            content = new FileReader(file).readString();
            log.info("读取Java文件内容成功：" + file.getAbsolutePath());
        }catch (Exception e) {
            log.error("读取Java文件内容失败！");

        }
        return content;
    }
}
