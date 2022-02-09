package com.sumsec.core.cfg;

import com.sumsec.core.cfg.core.Image;
import com.sumsec.core.cfg.uitls.FindDot;
import com.sumsec.core.cfg.uitls.OSUtil;
import com.sumsec.util.ConstatField;
import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * @ClassName: ImageSet
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 17:32
 * @Version: v1.0.0
 * @Description:
 **/
public class ImageUtil {
    private static Logger log = LogManager.getLogger(ImageUtil.class);

    public void setImage(String[] iURL) {
        for (String url : iURL) {
            log.info("iURL: " + url);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            File file = new File(url);
            if (!file.exists()) {
                log.error("文件不存在");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("文件不存在");
                alert.setContentText("请检查是否成功生成文件 "+ url);
                alert.show();
            } else {
                try {
                    Image.image = ImageIO.read(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int Height = Image.image.getHeight() + 100;
                int Width = Image.image.getWidth() + 100;
                log.info("图片大小 width:" + Width + " height:" + Height);
                new Image(Width, Height);
            }
        }
    }


    public String[] Dot2Image(String mName){
        // TODO
        FindDot findDot = new FindDot();
        String[] dotPath = findDot.findDotCFG(mName);
        OSUtil osUtil = new OSUtil();
//        String imgPath = ConstatField.ResultTemp + ConstatField.separator + mName + ".png";
        return osUtil.RunCmd(dotPath);
    }

//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(new ImageView(Image.image).getScene());
//
//    }
    public static void main(String[] args) {
//        new ImageUtil().setImage("G:\\GitHubProject\\SPATool\\result\\707310866707800\\main.png");
    }
}
