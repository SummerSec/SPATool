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
    public void copyFile(String dest,String file,boolean isCFG) {
        FindFiles findFiles = new FindFiles();
        if (isCFG) {
            if (file.contains("dot")) {
                log.info("copy file from " + ConstatField.sootOutputTemp + " to " + dest);
                String[] dots = findFiles.findFiles(ConstatField.sootOutputTemp, "dot");
                for (String dot : dots) {
                    log.info("复制成功 " + dot);
                    FileUtil.copyFile(dot,dest);
                }
            }else if (file.contains("png")){
                log.info("copy file from " + ConstatField.ResultTemp + " to " + dest);
                String[] pngs = findFiles.findFiles(ConstatField.ResultTemp, "png");
                for (String png : pngs) {
                    log.info("复制成功 " + png);
                    FileUtil.copyFile(png,dest);
                }
            }
        }else {
            if (file.contains("dot")) {
                log.info("copy file from " + ConstatField.sootOutputTemp + " to " + dest);
                String[] dots = findFiles.findFiles(ConstatField.sootOutputTemp, "dot");
                for (String dot : dots) {
                    log.info("复制成功 " + dot);
                    FileUtil.copyFile(dot,dest);
                }
            }else if (file.contains("png")){
                log.info("copy file from " + ConstatField.ASTResultTemp + " to " + dest);
                String[] pngs = findFiles.findFiles(ConstatField.ASTResultTemp, "png");
                for (String png : pngs) {
                    log.info("复制成功 " + png);
                    FileUtil.copyFile(png,dest);
                }
            }else if(file.contains("json")){
                String[] json = findFiles.findFiles(ConstatField.ASTHomeTemp, "json");
                for (String js : json) {
                    log.info("复制成功 " + js);
                    FileUtil.copyFile(js,dest);
                }
            }else if(file.contains("yaml")){
                String[] yaml = findFiles.findFiles(ConstatField.ASTHomeTemp, "yaml");
                for (String ym : yaml) {
                    log.info("复制成功 " + ym);
                    FileUtil.copyFile(ym,dest);
                }
            }else if (file.contains("xml")){
                String[] xml = findFiles.findFiles(ConstatField.ASTHomeTemp, "xml");
                for (String xm : xml) {
                    log.info("复制成功 " + xm);
                    FileUtil.copyFile(xm,dest);
                }
            }
        }

    }

}
