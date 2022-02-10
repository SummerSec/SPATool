package com.sumsec.core.ast.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ASTType {
    private static Logger log = LogManager.getLogger(ASTType.class);

    String getType() {
        return null;
    }
    public void handle(String content,String filepath) {
        log.debug("ASTType");
    }
}
