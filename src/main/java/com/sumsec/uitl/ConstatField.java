package com.sumsec.uitl;

import java.io.File;

/**
 * @ClassName: ConstatField
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/6 21:08
 * @Version: v1.0.0
 * @Description:
 **/
public class ConstatField {

    public final static String HOME = System.getProperty("user.dir");
    public static final String separator = File.separator;
    public final static String CFGHOME = HOME + separator + "datas" + separator + "cfg";
    public final static String Result = HOME + separator + "result";




}
