package com.sumsec.core.cfg.uitls;

import com.sumsec.uitl.ConstatField;
import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static cn.hutool.core.io.FileUtil.mkdir;

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

    public String RunCmd(String imgPath,String dotPath){
        boolean isWindowsOS = isWindowsOS();
        String[] cmd;
        mkdir(ConstatField.ResultTemp);
//        String path = ConstatField.ResultTemp + ConstatField.separator + name + ".png";
        if(isWindowsOS){
            //windows下的命令
             cmd = new String[]{"cmd.exe", "/c", "dot", "-Tpng", dotPath, "-o", imgPath};
        }else {
            //linux下的命令
             cmd = new String[]{"/bin/sh", "-c", "dot", "-Tpng" + dotPath + "-o" , imgPath};
        }
        try {
            logger.info("开始生成图片");
            Runtime.getRuntime().exec(cmd);
            logger.info("生成图片成功");
            logger.info("图片路径为：" + imgPath);
            return imgPath;
        }catch (Exception e){
            logger.error("生成图片失败");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            logger.error(e.getMessage());
            return null;
        }

    }


    public static void main(String[] args) {
        OSUtil osUtil = new OSUtil();
        osUtil.RunCmd("tmethod638287524801000.png","G:\\GitHubProject\\SPATool\\sootOutput\\tmethod638287524801000 void main(java.lang.String[]).dot" );
    }

}
