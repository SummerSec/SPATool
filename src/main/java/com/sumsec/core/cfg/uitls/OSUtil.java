package com.sumsec.core.cfg.uitls;

import com.sumsec.util.ConstatField;
import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static cn.hutool.core.io.FileUtil.checkSlip;
import static cn.hutool.core.io.FileUtil.mkdir;
import static java.lang.Thread.sleep;

/**
 * @ClassName: isWinOS
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 17:45
 * @Version: v1.0.0
 * @Description:
 **/
public class OSUtil {
    private static Logger logger = LogManager.getLogger(OSUtil.class);
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            logger.info("当前操作系统为：" + osName);
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    public String[] RunCmd(String[] dotPath){
        boolean isWindowsOS = isWindowsOS();
        String[] cmd;
        mkdir(ConstatField.ResultTemp);
        ArrayList<String> imgPaths = new ArrayList<>();
//        String path = ConstatField.ResultTemp + ConstatField.separator + name + ".png";
        logger.info(dotPath.length);
        for (int i = 0; i < dotPath.length; i++) {
            String imgPath = ConstatField.ResultTemp + ConstatField.separator + dotPath[i].substring(dotPath[i].lastIndexOf("\\") + 1, dotPath[i].lastIndexOf(".")) + ".png";
            if (isWindowsOS) {
                //windows下的命令
                cmd = new String[]{"cmd.exe", "/c", "dot", "-Tpng", dotPath[i], "-o", imgPath};
            } else {
                //linux下的命令
                cmd = new String[]{"/bin/sh", "-c", "dot", "-Tpng" + dotPath[i] + "-o", imgPath};
            }
            try {

                logger.info("开始生成图片 " + dotPath[i]);
                logger.info("正在执行命令 " + Arrays.toString(cmd));
                sleep(1000);
                String charsetName = isWindowsOS ? "GBK" : "UTF-8";
                byte[] bytes = new Scanner(Runtime.getRuntime().exec(cmd).getInputStream(), charsetName).useDelimiter("\\A").next().getBytes(charsetName);
                if (bytes.length > 0) {
                    logger.info("something wrong");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("警告");
                    alert.setContentText(new String(bytes, charsetName));
                    alert.show();
                } else{
                    logger.info("生成图片成功");
                    logger.info("图片路径为：" + imgPath);
                    imgPaths.add(imgPath);
                }
            } catch (Exception e) {
                logger.error("生成图片失败 " + dotPath[i]);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.show();
                logger.error(e.getMessage());
            }
        }
        return imgPaths.toArray(new String[0]);

    }


    public static void main(String[] args) {
        OSUtil osUtil = new OSUtil();
//        osUtil.RunCmd("tmethod638287524801000.png","G:\\GitHubProject\\SPATool\\sootOutput\\tmethod638287524801000 void main(java.lang.String[]).dot" );
    }

}
