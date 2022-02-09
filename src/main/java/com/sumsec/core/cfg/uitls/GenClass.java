package com.sumsec.core.cfg.uitls;

import com.sumsec.core.cfg.core.TMethod;
import com.sumsec.core.cfg.core.Template;
import com.sumsec.util.ConstatField;
import javassist.CtClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import static cn.hutool.core.io.FileUtil.mkdir;

/**
 * @ClassName: genClass
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 13:16
 * @Version: v1.0.0
 * @Description: 生成class文件到cfghome目录下
 **/
public class GenClass {

    private static Logger log = LogManager.getLogger(GenClass.class);
    // 生成class文件到cfghome目录下
    public static void genClassM(String mName,String mContext){
        String className = null;
        Template template = new TMethod();
        try {
            CtClass clzz = template.genMethod(mName,mContext);
            className = TMethod.clsName;
            log.info("开始生成class： " + className);
            byte[] bytes = clzz.toBytecode();
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String file = ConstatField.CFGHOMETemp ;
            mkdir(file);
            FileOutputStream fos = new FileOutputStream(file + ConstatField.separator + className + ".class");
            fos.write(bytes);
//            fos.flush();
            fos.close();
            log.info("生成class： " + className + "成功");
        }catch (Exception e){
            log.error("生成class失败： " + className);
            log.error(e.getMessage());
        }
    }




}
