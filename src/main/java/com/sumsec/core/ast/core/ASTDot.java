package com.sumsec.core.ast.core;

import cn.hutool.core.io.file.FileWriter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.javaparser.StaticJavaParser.parse;

/**
 * @ClassName: ASTDot
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 13:52
 * @Version: v1.0.0
 * @Description:
 **/
public class ASTDot extends ASTType{

    private static Logger log = LogManager.getLogger(ASTDot.class);

    @Override
    public String getType() {
        return "dot";
    }

    @Override
    public void handle(String content,String filepath) {
        log.info("dot handle");
        CompilationUnit cu = parse(content);
        YamlPrinter printer = new YamlPrinter(true);
        log.info(printer.output(cu));
        FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.write(printer.output(cu));
        log.info("write file success");
        log.info("Dot file path: "+ filepath);
        log.info("dot handle end");
    }


}
