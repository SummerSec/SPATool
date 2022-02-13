package com.sumsec.core.cfg;

import cn.hutool.core.io.FileUtil;
import com.sumsec.core.cfg.core.CFGViewerOver;
import com.sumsec.core.cfg.core.TMethod;
import com.sumsec.core.cfg.uitls.GenClass;
import com.sumsec.core.cfg.uitls.Prepare;
import com.sumsec.util.ConstatField;
import com.sumsec.util.DFS;
import javafx.scene.control.Alert;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import soot.Scene;
import soot.SootClass;
import soot.options.Options;
import soot.tools.CFGViewer;

import java.io.File;
import java.util.ArrayList;

import static cn.hutool.core.io.FileUtil.mkdir;
import static soot.SootClass.SIGNATURES;


/**
 * @ClassName: generate
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 12:48
 * @Version: v1.0.0
 * @Description: cfg文件生成
 **/
public class Generate {
    private static Logger log = LogManager.getLogger(Generate.class);

    // 输入方法内容生成cfg
    public String methodG(String mname, String mcontext){
        try {
            GenClass.genClassM(mname, mcontext);
        }catch (Exception e){
            log.error("生成class文件错误");
        }
        return TMethod.clsName;
    }
    // 生成一个类文件的CFG图
    public boolean DotG(String graphtype,String filename){
        try {

            if (ConstatField.flag) {
                ConstatField.viewer = CFGViewerOver.CFGViewerOver();
                ConstatField.flag = false;
                log.info("准备环境 prepare");
                Prepare prepare = new Prepare();
                prepare.Envprepare();
                Options.v().set_prepend_classpath(true);
                Options.v().set_allow_phantom_refs(true);
                Options.v().set_soot_classpath(ConstatField.CFGHOMETemp);
            }

            if (filename.endsWith(".class")){
                filename = filename.substring(0,filename.length()-6);
            }else {
                filename = TMethod.clsName;
            }
            ConstatField.filename = filename;
            Scene.v().loadClassAndSupport(filename);
            mkdir(ConstatField.sootOutputTemp);
            String[] arg = new String[]{filename, "--graph=" + graphtype,"-force-overwrite","-d",ConstatField.sootOutputTemp};
            log.info("arg: " + arg[0] + " " + arg[1] + " " + arg[2] + " " + arg[3] + " " + arg[4]);
            log.info("开始生成cfg图");
            log.info("生成的文件名为："+filename);
            log.info("生成的图类型为："+graphtype);
            CFGViewerOver.main(ConstatField.viewer, arg);
            log.info("cfg图生成完成");
            return true;
        }catch (Exception e){
            log.error("生成Dot错误");
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            log.error(e.getMessage());
            return false;
        }
    }



}
