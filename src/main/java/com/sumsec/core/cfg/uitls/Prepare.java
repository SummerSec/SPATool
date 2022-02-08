package com.sumsec.core.cfg.uitls;

import com.sumsec.uitl.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import soot.options.Options;

/**
 * @ClassName: prepare
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 12:40
 * @Version: v1.0.0
 * @Description:
 **/
public class Prepare {
    private Logger log = LogManager.getLogger(Prepare.class);

    public void Envprepare(){
        log.info("检测环境");
        Options.v().set_prepend_classpath(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_soot_classpath(ConstatField.CFGHOMETemp);
//        Options.v().set_whole_program(true);
        log.info("CFG环境设置完成");
        log.info("CFG Home: " + ConstatField.CFGHOMETemp);
    }
}
