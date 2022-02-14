package cfg;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @ClassName: demo
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/6 19:43
 * @Version: v1.0.0
 * @Description:
 **/
public class demo {
    public static void main(String[] args) throws IOException {
        boolean isWindowsOS = isWindowsOS();
        String charsetName = isWindowsOS ? "GBK" : "UTF-8";
        String[] cmd;
        if (isWindowsOS) {
            //windows下的命令
            cmd = new String[]{"cmd.exe", "/c"};
        } else {
            //linux下的命令
            cmd = new String[]{"/bin/sh", "-c"};
        }
        byte[] bytes = new Scanner(Runtime.getRuntime().exec(cmd).getInputStream(), charsetName).useDelimiter("\\A").next().getBytes(charsetName);
        System.out.println(bytes.length);
        if (bytes.length >= 17) {
            System.out.println(new String(bytes, charsetName));

        }
        System.out.println(new String(bytes, charsetName));
    }
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
//            logger.info("当前操作系统为：" + osName);
            isWindowsOS = true;
        }
        return isWindowsOS;
    }
}
