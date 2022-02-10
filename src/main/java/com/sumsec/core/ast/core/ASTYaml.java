package com.sumsec.core.ast.core;

import cn.hutool.core.io.file.FileWriter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.github.javaparser.StaticJavaParser.parse;

/**
 * @ClassName: ASTYaml
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 15:27
 * @Version: v1.0.0
 * @Description:
 **/
public class ASTYaml extends ASTType{
    private static Logger log = LogManager.getLogger(ASTYaml.class);

    @Override
    public String getType() {
        return "yaml";
    }

    public void handle(String content,String filePath) {
        log.info("handle yaml");
        CompilationUnit cu = parse(content);
        YamlPrinter printer = new YamlPrinter(true);
        log.info(printer.output(cu));
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(printer.output(cu));
        log.info("write yaml success");
        log.info("Yaml file path: {}",filePath);
        log.info("handle yaml end");
    }
}
