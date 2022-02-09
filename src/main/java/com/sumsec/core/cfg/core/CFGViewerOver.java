package com.sumsec.core.cfg.core;

import soot.Main;
import soot.PackManager;
import soot.Transform;
import soot.tools.CFGViewer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: CFGViewerOver
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/8 23:09
 * @Version: v1.0.0
 * @Description:
 **/
public class CFGViewerOver {
    public static void parse_options(CFGViewer viewer,String[] args) {
        try {
            Method method = viewer.getClass().getDeclaredMethod("parse_options", String[].class);
            method.setAccessible(true);
            Object obj = method.invoke(viewer,new Object[]{args});
            Main.main((String[]) obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(CFGViewer viewer,String[] args) {
        parse_options(viewer, args);
    }
    public static CFGViewer CFGViewerOver(){
        CFGViewer viewer = new CFGViewer();
        Transform printTransform = new Transform("jtp.printcfg", viewer);
        printTransform.setDeclaredOptions("enabled alt-class-path graph-type ir multipages brief ");
        printTransform.setDefaultOptions("enabled alt-class-path: graph-type:BriefUnitGraph ir:jimple multipages:false  brief:false ");
        PackManager.v().getPack("jtp").add(printTransform);
        return viewer;
    }
}
