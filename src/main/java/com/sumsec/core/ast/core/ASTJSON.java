package com.sumsec.core.ast.core;

import cn.hutool.core.io.file.FileWriter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.javaparser.StaticJavaParser.parse;

/**
 * @ClassName: ASTJSON
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 15:26
 * @Version: v1.0.0
 * @Description:
 **/
public class ASTJSON extends ASTType {

    private static Logger log = LogManager.getLogger(ASTJSON.class);

    @Override
    public String getType() {
        return "JSON";
    }
    @Override
    public void handle(String content,String filepath) {
        log.info("handle JSON");
        CompilationUnit cu = parse(content);
        YamlPrinter printer = new YamlPrinter(true);
        log.info(printer.output(cu));
        FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.write(printer.output(cu));
        log.info("write JSON to file");
        log.info("Json file path: {}",filepath);
        log.info("handle JSON end");
    }

}
