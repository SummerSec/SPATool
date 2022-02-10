package com.sumsec.core.cfg.uitls;


import com.sumsec.util.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

/**
 * @ClassName: FindFiles
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 13:27
 * @Version: v1.0.0
 * @Description:
 **/
public class FindFiles {
    private static Logger log = LogManager.getLogger(FindFiles.class);
    public String[] findFiles(String src,String name){
        File file = new File(src);
        File[] files = file.listFiles();
        ArrayList<String> dots = new ArrayList<>();
        for (File f : files) {
            if (f.getName().toLowerCase().contains(name.toLowerCase())) {
                log.info("找到dot文件：" + f.getAbsolutePath());
                dots.add(f.getAbsolutePath());
            }
        }
        return dots.toArray(new String[0]);
    }
}
