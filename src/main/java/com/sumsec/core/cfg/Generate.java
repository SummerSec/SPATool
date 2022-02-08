package com.sumsec.core.cfg;

import com.sumsec.core.cfg.core.TMethod;
import com.sumsec.core.cfg.uitls.GenClass;
import com.sumsec.core.cfg.uitls.Prepare;
import com.sumsec.core.cfg.uitls.SelectC;
import com.sumsec.uitl.ConstatField;
import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import soot.Scene;
import soot.options.Options;
import soot.tools.CFGViewer;


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
            Prepare prepare = new Prepare();
            prepare.Envprepare();
            Options.v().set_prepend_classpath(true);
            Options.v().set_allow_phantom_refs(true);
            Options.v().set_soot_classpath(ConstatField.CFGHOMETemp);
            Scene.v().loadClassAndSupport(TMethod.clsName);
            Scene.v().loadNecessaryClasses();
            String[] arg = new String[]{filename, "--graph=" + graphtype};
            log.info("开始生成cfg图");
            log.info("生成的文件名为："+filename);
            log.info("生成的图类型为："+graphtype);
            CFGViewer.main(arg);
            log.info("cfg图生成完成");
            return true;
        }catch (Exception e){
            log.error("生成Dot错误");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            log.error(e.getMessage());
            return false;
        }
    }



}
