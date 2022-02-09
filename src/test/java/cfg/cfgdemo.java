package cfg;

import soot.*;
import soot.options.Options;
import soot.toolkits.graph.ClassicCompleteUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.tools.CFGViewer;

import java.io.File;

/**
 * @ClassName: cfgdemo
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/5 15:04
 * @Version: v1.0.0
 * @Description:
 **/
public class cfgdemo {

    public static String sourceDirectory = "";
    public static String clsName = "";
    public static void setupSoot() {
        G.reset();
        Options.v().set_prepend_classpath(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_soot_classpath(sourceDirectory);
        SootClass sc = Scene.v().loadClassAndSupport(clsName);
        sc.setApplicationClass();
        Scene.v().loadNecessaryClasses();

    }
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "FizzBuzz";
        System.out.println(path);
        Options.v().set_prepend_classpath(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_soot_classpath(System.getProperty("user.dir"));
        Scene.v().loadClassAndSupport("FizzBuzz");

        Scene.v().loadNecessaryClasses();
//        Scene.v().addBasicClass("FizzBuzz", SootClass.BODIES);
        String[] arg = new String[]{ "FizzBuzz", "--graph=BriefUnitGraph","-d", "output"};
        try {
            CFGViewer.main(arg);
            CFGViewer.main(arg);
        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
