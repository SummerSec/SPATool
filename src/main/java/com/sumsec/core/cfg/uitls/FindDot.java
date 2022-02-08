package com.sumsec.core.cfg.uitls;

import com.sumsec.uitl.ConstatField;

import java.io.File;

/**
 * @ClassName: FindDot
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 17:38
 * @Version: v1.0.0
 * @Description:
 **/
public class FindDot {

    private final static String sootOutput = System.getProperty("user.dir") + ConstatField.separator +"sootOutput";
    // 从文件夹中寻找生成的dot文件cfg
    public String findDotCFG(String name){
        File file = new File(sootOutput);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().toLowerCase().contains(name.toLowerCase())) {
                return f.getAbsolutePath();
            }
        }
        return null;
    }


    // 寻找文件夹中dot文件并转化成图片
    public String findDotImage(String name){
        File file = new File(ConstatField.ResultTemp);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().toLowerCase().contains(name.toLowerCase())) {
                f.getAbsolutePath();
            }
        }
        return null;
    }


}
