package com.sumsec.core.cfg.uitls;

import cn.hutool.core.io.FileUtil;
import com.sumsec.util.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static cn.hutool.core.io.FileUtil.mkdir;

/**
 * @ClassName: SelectC
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 13:30
 * @Version: v1.0.0
 * @Description:
 **/
public class SelectC {
    private static Logger log = LogManager.getLogger(SelectC.class);

    public static void selectFile(String filePath, String CFGFileName) {
        log.info("select file: " + filePath);
        log.info("复制Class文件到：" + ConstatField.CFGHOMETemp);
        mkdir(ConstatField.CFGHOMETemp);
        if (!FileUtil.exist(ConstatField.CFGHOMETemp + ConstatField.separator + CFGFileName)) {
            FileUtil.copyFile(filePath, ConstatField.CFGHOMETemp);
            log.info("复制成功 " + ConstatField.CFGHOMETemp + "\\" + CFGFileName);
        }else{
            log.info("文件已存在，不需要复制");
        }


    }

    public static void main(String[] args) {
        selectFile("G:\\GitHubProject\\SPATool\\tmethod637400787345300.class","G:\\GitHubProject\\SPATool\\temp\\");
    }
}
