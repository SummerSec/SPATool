package com.sumsec.ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: main
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/4 13:20
 * @Version: v1.0.0
 * @Description:
 **/
public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static Logger logger = LogManager.getLogger(main.class);
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui.fxml"));
        primaryStage.setTitle("Static Analysis Tool by SummerSec");
//        Image icon = new Image(String.valueOf(getClass().getResource("/icon.png")));
//        primaryStage.getIcons().add(icon);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        logger.info("Application started");


    }
    public main(){}


}
