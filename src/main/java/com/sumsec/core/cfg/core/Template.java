package com.sumsec.core.cfg.core;

import javassist.CtClass;

/**
 * @ClassName: template
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 13:13
 * @Version: v1.0.0
 * @Description:
 **/
public interface Template<T> {
    CtClass genMethod(String mName,String mContext) throws Exception;

}
