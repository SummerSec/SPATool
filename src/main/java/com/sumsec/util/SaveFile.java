package com.sumsec.util;

import com.sumsec.core.cfg.uitls.CopyFile;
import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @ClassName: SaveFile
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 13:44
 * @Version: v1.0.0
 * @Description:
 **/
public class SaveFile {
    public void Save(String name){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        File file = directoryChooser.showDialog(new Stage());
        CopyFile copyFile = new CopyFile();
        try {
            copyFile.copyFile(file.getAbsolutePath(),name);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText("保存成功");
            alert.show();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
