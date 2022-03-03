package com.sumsec.core.cfg.core;

import com.sumsec.util.ConstatField;
import soot.*;
import soot.tools.CFGViewer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static soot.SootClass.SIGNATURES;

/**
 * @ClassName: CFGViewerOver
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/8 23:09
 * @Version: v1.0.0
 * @Description:
 **/
public class CFGViewerOver {
    public static Object parse_options(CFGViewer viewer,String[] args) {
        try {
            Method method = viewer.getClass().getDeclaredMethod("parse_options", String[].class);
            method.setAccessible(true);
            return method.invoke(viewer,new Object[]{args});

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(CFGViewer viewer,String[] args) {
        Object obj = parse_options(viewer, args);
        Scene.v().addBasicClass(args[0], SIGNATURES);


        System.out.println(args[0]);
        ConstatField.main.run((String[]) obj);
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
