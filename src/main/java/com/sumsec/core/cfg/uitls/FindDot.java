package com.sumsec.core.cfg.uitls;

import com.sumsec.util.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: FindDot
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 17:38
 * @Version: v1.0.0
 * @Description:
 **/
public class FindDot {

    private static Logger log = LogManager.getLogger(FindDot.class);
    // 从文件夹中寻找生成的dot文件cfg
    public String[] findDotCFG(String name){
        File file = new File(ConstatField.sootOutputTemp);
        File[] files = file.listFiles();
        ArrayList<String> dots = new ArrayList<>();
        for (File f : files) {
            if (f.getName().toLowerCase().contains(".dot")) {
                log.info("找到dot文件：" + f.getAbsolutePath());
                dots.add(f.getAbsolutePath());
            }
        }
        return dots.toArray(new String[0]);
    }




}
