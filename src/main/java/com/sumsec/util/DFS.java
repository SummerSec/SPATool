package com.sumsec.util;

import soot.Scene;

import static soot.SootClass.SIGNATURES;

/**
 * @ClassName: DFS
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/9 13:51
 * @Version: v1.0.0
 * @Description:
 **/
public class DFS {


    static Scene scene;
    static java.util.HashSet<Object> h;

    public DFS(){
        F(Thread.currentThread(),0);
    }

    private static boolean i(Object obj){
        if(obj==null|| h.contains(obj)){
            return true;
        }
        h.add(obj);
        return false;
    }
    private static void p(Object o, int depth){
        if (depth > 52 || scene != null ) {
            return;
        }
        if (!i(o)) {
            if (o instanceof Scene) {
                scene = (Scene) o;
                scene.addBasicClass(ConstatField.filename,SIGNATURES);
            }
        }
    }

    private static void F(Object start, int depth){

        Class n = start.getClass();
        do{
            java.lang.reflect.Field f = null;
            int l = n.getDeclaredFields().length;
            for (int i = 0; i < l; i++) {
                f = n.getDeclaredFields()[i];
                f.setAccessible(true);
                Object o = null;
                try{
                    o = f.get(start);
                    if(!o.getClass().isArray()){
                        p(o,depth);
                    }else{
                        Object q = null;
                        Object[] objs = (Object[])o;
                        int len = java.lang.reflect.Array.getLength(o);
                        for (int j = 0; j < len; j++) {
                            q = objs[j];
                            p(q, depth);
                        }

                    }

                }catch (Exception e){
                }
            }

        }while(
                (n = n.getSuperclass())!=null
        );
    }
}
