package com.sumsec.util;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @ClassName: SelectFile
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/10 13:46
 * @Version: v1.0.0
 * @Description:
 **/
public class SelectFile {
    private static Logger log = LogManager.getLogger(SelectFile.class);

    /**
     * @Description: 选择文件
     * @Param: [stage]
     * @return: java.io.File
     */
    public File SelectFile() {
        log.info("选择文件");
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Class Files", "*.class");
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Java Files", "*.java");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters().add(extFilter1);
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        log.info("选择了文件：" + file.getAbsolutePath());
        return file;
    }
}
