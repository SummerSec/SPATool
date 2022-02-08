package com.sumsec.core.cfg;

import com.sumsec.core.cfg.uitls.FindDot;
import com.sumsec.core.cfg.uitls.OSUtil;
import com.sumsec.uitl.ConstatField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * @ClassName: ImageSet
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/7 17:32
 * @Version: v1.0.0
 * @Description:
 **/
public class ImageUtil {

    public void setImage(String iURL, ImageView imageView){
//        System.out.println(iURL);
        File file = new File(iURL);
        try {
            String url = file.toURI().toURL().toString();
            imageView.setImage(new Image(url));
            Stage stage = new Stage();
            stage.setWidth(imageView.getImage().getWidth());
            stage.setHeight(imageView.getImage().getHeight());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String Dot2Image(String mName){
        // TODO
        FindDot findDot = new FindDot();
        String dotPath = findDot.findDotCFG(mName);
        OSUtil osUtil = new OSUtil();
        String imgPath = ConstatField.ResultTemp + ConstatField.separator + mName + ".png";
        return osUtil.RunCmd(imgPath, dotPath);
    }
}
