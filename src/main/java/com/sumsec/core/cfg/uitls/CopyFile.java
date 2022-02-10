package com.sumsec.core.cfg.uitls;

import cn.hutool.core.io.FileUtil;
import com.sumsec.util.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: CopyFile
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/9 15:45
 * @Version: v1.0.0
 * @Description:
 **/
public class CopyFile {
    private static Logger log = LogManager.getLogger(CopyFile.class);
    public void copyFile(String dest,String file) {
        if (file.contains("dot")) {
            log.info("copy file from " + ConstatField.sootOutputTemp + " to " + dest);
            FindFiles findFiles = new FindFiles();
            String[] dots = findFiles.findFiles(ConstatField.sootOutputTemp, "dot");
            for (String dot : dots) {
                log.info("复制成功 " + dot);
                FileUtil.copyFile(dot,dest);
            }
        }else if (file.contains("png")){
            log.info("copy file from " + ConstatField.ResultTemp + " to " + dest);
            FindFiles findFiles = new FindFiles();
            String[] pngs = findFiles.findFiles(ConstatField.ResultTemp, "png");
            for (String png : pngs) {
                log.info("复制成功 " + png);
                FileUtil.copyFile(png,dest);
            }
        }else if (file.contains("json")){

        }
    }

}
