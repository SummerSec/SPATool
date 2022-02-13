package cfg;

import com.sumsec.util.ConstatField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import static cn.hutool.core.io.FileUtil.mkdir;

/**
 * @ClassName: test
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/6 19:40
 * @Version: v1.0.0
 * @Description:
 **/
public class test {
    public static String str = "123";
    static {
        test.str = "456";
    }
    public static void main(String[] args) throws IOException {
        Logger log = LogManager.getLogger(test.class);
        log.info("info "+ "${sys:user.dir}");
        String s = "com.sumsec.core.cfg.core.tmethod635244167339300";
        System.out.println(s.split("\\.")[5]);
        System.out.println(ConstatField.CFGHOMETemp);
//        System.out.println(ConstatField.CFGHOME);
        File file = new File(ConstatField.CFGHOMETemp + "\\635244167339300"+ ConstatField.separator + s.split("\\.")[5] + ".class");
//        mkdir(file);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("asd".getBytes());
        fos.close();
  }



}
