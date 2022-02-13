package com.sumsec.core.ast.core;

import cn.hutool.core.io.file.FileWriter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import com.github.javaparser.serialization.JavaParserJsonSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

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
        JavaParserJsonSerializer jsonSerializer = new JavaParserJsonSerializer();
        Map<String, ?> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, null);
        StringWriter writer = new StringWriter();
        JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(config);
        JsonGenerator jsonGenerator = generatorFactory.createGenerator(writer);
        jsonSerializer.serialize(cu,jsonGenerator);
        FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.write(writer.toString());

        log.info("write JSON to file");
        log.info("Json file path: {}",filepath);
        log.info("handle JSON end");
    }

}
