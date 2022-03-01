package com.sumsec.core.ast;

import com.sumsec.core.ast.core.*;
import com.sumsec.core.ast.util.ASTSave;
import com.sumsec.core.ast.util.DotHandler;
import com.sumsec.core.ast.util.FindFile;
import com.sumsec.util.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashMap;

/**
 * @ClassName: parser
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/5 14:57
 * @Version: v1.0.0
 * @Description:
 **/
public class Parser {
    private static Logger log = LogManager.getLogger(Parser.class);
    private static HashMap<String,ASTType> hashMap = new HashMap<>();
    public void parse(String content,String filetype,boolean img) {
        log.info("开始解析文件");
        log.info("准备环境");
        hashMap.put("DOT",new ASTDot());
        hashMap.put("JSON",new ASTJSON());
        hashMap.put("XML",new ASTXML());
        hashMap.put("YAML",new ASTYaml());
        hashMap.get(filetype).handle(content, ConstatField.ASTHomeTemp + File.separator + System.nanoTime() + "." + filetype.toLowerCase());
        if (filetype.contains("DOT") && img) {
            log.info("dot转化图片");
            DotHandler dotHandler = new DotHandler();
            dotHandler.ImageHandler();
        }
    }

}
