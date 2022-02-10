package com.sumsec.core.ast.core;

import cn.hutool.core.io.file.FileWriter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.javaparser.StaticJavaParser.parse;

/**
 * @ClassName: ASTXML
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 15:26
 * @Version: v1.0.0
 * @Description:
 **/
public class ASTXML extends ASTType{

    private static Logger log = LogManager.getLogger(ASTXML.class);

    @Override
    public String getType(){
        return "xml";
    }

    @Override
    public void handle(String content,String filePath) {
        log.info("handle ASTXML");
        CompilationUnit cu = parse(content);
        YamlPrinter printer = new YamlPrinter(true);
        log.info(printer.output(cu));
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(printer.output(cu));
        log.info("write xml file success");
        log.info("Xml file path: "+filePath);
        log.info("handle xml end");

    }

}
