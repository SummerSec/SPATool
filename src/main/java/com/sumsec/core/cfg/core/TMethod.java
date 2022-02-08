package com.sumsec.core.cfg.core;

import javassist.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


/**
 * @ClassName: tmethod
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 12:55
 * @Version: v1.0.0
 * @Description: 模板方法类
 **/
public class TMethod implements Template {
    private static Logger log = LogManager.getLogger(TMethod.class);
    public static String clsName = "hello";

    @Override
    public CtClass genMethod(String mName,String mContext) throws NotFoundException {
        clsName = "tmethod" + System.nanoTime();

        log.info("开始生成模板类：" + clsName);
        CtClass clzz = ClassPool.getDefault().makeClass(clsName);
        if ((clzz.getDeclaredConstructors()).length != 0) {
            clzz.removeConstructor(clzz.getDeclaredConstructors()[0]);
        }
        try {
            System.out.println(mContext);
            clzz.addMethod(CtMethod.make(mContext,clzz)); //添加方法
            log.info("生成模板类：" + clsName + "成功");
            log.info("开始生成模板方法：" + mName);

        }catch (Exception e){
            log.error("生成模板类失败：" + clsName);
            log.error(e.getMessage());
        }
        return clzz;
    }

    public static void main(String[] args) {
        String mName = "hello";
        String mContext = "public void hello(){}";
        try {
            TMethod tMethod = new TMethod();
            CtClass clzz = tMethod.genMethod(mName,mContext);
            clzz.writeFile("datas");
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }
    }
}
