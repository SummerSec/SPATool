package cfg;

import com.sumsec.core.cfg.core.CFGViewerOver;
import com.sumsec.util.ConstatField;
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
        Scene.v().loadClassAndSupport("tmethod637400787345300");

        Scene.v().loadNecessaryClasses();
//        Scene.v().addBasicClass("FizzBuzz", SootClass.BODIES);
        String[] arg = new String[]{ "FizzBuzz", "--graph=BriefUnitGraph","-d", "output"};
        try {
            ConstatField.viewer = CFGViewerOver.CFGViewerOver();
            CFGViewerOver.main(ConstatField.viewer, arg);
            arg = new String[]{"tmethod637400787345300", "--graph=BriefUnitGraph"};
//            ConstatField.viewer = CFGViewerOver.CFGViewerOver();
            CFGViewerOver.main(ConstatField.viewer, arg);
        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
