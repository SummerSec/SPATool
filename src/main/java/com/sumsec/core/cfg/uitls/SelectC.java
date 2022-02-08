package com.sumsec.core.cfg.uitls;

import cn.hutool.core.io.FileUtil;
import com.sumsec.uitl.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import soot.util.Cons;

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

    public static void selectFile(String filePath) {
        log.info("select file: " + filePath);
        log.info("复制Class文件到：" + ConstatField.CFGHOMETemp);
        FileUtil.copyFile(filePath, ConstatField.CFGHOMETemp);
        log.info("复制成功");
    }
}
