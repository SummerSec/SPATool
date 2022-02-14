package com.sumsec.core.ast.util;

import com.sumsec.core.cfg.uitls.ImageBak;
import com.sumsec.core.cfg.uitls.Images;
import com.sumsec.util.ConstatField;
import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static cn.hutool.core.io.FileUtil.mkdir;
import static com.sumsec.core.cfg.uitls.OSUtil.isWindowsOS;
import static java.lang.Thread.sleep;

/**
 * @ClassName: DotHandler
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 15:44
 * @Version: v1.0.0
 * @Description:
 **/
public class DotHandler  {
    private static Logger logger = LogManager.getLogger(DotHandler.class);
    public String[] RunCmd(String[] dotPath){
        boolean isWindowsOS = isWindowsOS();
        String[] cmd;
        mkdir(ConstatField.ResultTemp);
        ArrayList<String> imgPaths = new ArrayList<>();
//        String path = ConstatField.ResultTemp + ConstatField.separator + name + ".png";
        for (int i = 0; i < dotPath.length; i++) {
            String imgPath = ConstatField.ASTResultTemp + ConstatField.separator + dotPath[i].substring(dotPath[i].lastIndexOf("\\") + 1, dotPath[i].lastIndexOf(".")) + ".png";
            if (isWindowsOS) {
                //windows下的命令
                cmd = new String[]{"cmd.exe", "/c", "dot", "-Tpng", dotPath[i], "-o", imgPath};
            } else {
                //linux下的命令
                cmd = new String[]{"/bin/sh", "-c", "dot", "-Tpng" + dotPath[i] + "-o", imgPath};
            }
            try {

                logger.info("开始生成图片 " + dotPath[i]);
                logger.info("正在执行命令 "+ Arrays.toString(cmd));
                sleep(1000);
                String charsetName = isWindowsOS ? "GBK" : "UTF-8";
                byte[] bytes = new Scanner(Runtime.getRuntime().exec(cmd).getInputStream(), charsetName).useDelimiter("\\A").next().getBytes(charsetName);
                if (bytes.length > 17) {
                    logger.info("bytes.length = " + bytes.length);
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

    public void ImageHandler(){
        FindFile findFile = new FindFile();
        String[] dotPath = findFile.findFile(ConstatField.ASTHomeTemp, "dot");
        String[] img = this.RunCmd(dotPath);
        for (String s : img) {
            logger.info("图片路径为：" + s);
            try {
                sleep(1000);
                File image = new File(s);
                if (!image.exists()) {
                    logger.error("图片不存在");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("图片不存在");
                    alert.show();
                }else {
                    ImageBak.image = ImageIO.read(image);
                    int width = ImageBak.image.getWidth() + 100;
                    int height = ImageBak.image.getHeight() + 100;
                    logger.info("图片大小为：" + width + "*" + height);
//                    new ImageBak(width, height);
                    new Images(image);
                }
            } catch (InterruptedException e) {
                logger.info(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                logger.info(e.getMessage());
            }

        }
    }


}
