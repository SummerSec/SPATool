package com.sumsec.core.ast.util;

import cn.hutool.core.io.FileUtil;
import com.sumsec.core.cfg.uitls.CopyFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: ASTSave
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/11 14:07
 * @Version: v1.0.0
 * @Description:
 **/
public class ASTSave {
    private static Logger log = LogManager.getLogger(ASTSave.class);

    public boolean save(String[] filePath, String destPath) {
        log.info("save destPath: " + destPath);
        for (String path : filePath) {
            log.info("save path: " + path + " to " + destPath);
            try {
                FileUtil.copyFile(path, destPath);
            }catch (Exception e){
                log.error("save error: " + e.getMessage());
                return false;
            }
            log.info("save success");
        }
        return true;
    }
}
