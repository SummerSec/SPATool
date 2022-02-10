package com.sumsec.core.ast.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

/**
 * @ClassName: FindFile
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 16:30
 * @Version: v1.0.0
 * @Description:
 **/
public class FindFile {
    private static Logger log = LogManager.getLogger(FindFile.class);
    public String[] findFile(String src,String name){
        File file = new File(src);
        File[] files = file.listFiles();
        ArrayList<String> dots = new ArrayList<>();
        for (File f : files) {
            if (f.getName().toLowerCase().contains(name.toLowerCase())) {
                log.info("找到文件：" + f.getAbsolutePath());
                dots.add(f.getAbsolutePath());
            }
        }
        return dots.toArray(new String[0]);
    }
}
