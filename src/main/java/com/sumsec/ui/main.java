package com.sumsec.ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
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
    private static Options OPTIONS = new Options();
    private static CommandLine commandLine;
    private static String HELP_STRING = null;
    private static Logger logger = LogManager.getLogger(main.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.info("No arguments provided");
            logger.info("Starting application with default arguments");
            launch(args);
        }else{
            for (String arg : args) {
                logger.info(arg);
            }
            initCliArgs(args);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui.fxml"));
        primaryStage.setTitle("Static Analysis Tool by SummerSec");
        Image icon = new Image(String.valueOf(getClass().getResource("/icon.png")));
        primaryStage.getIcons().add(icon);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        logger.info("Application started");


    }
    public main(){}
    private static void initCliArgs(String[] args) {
        CommandLineParser parser = new org.apache.commons.cli.DefaultParser();

        OPTIONS.addOption("h", "help", false, "Print this help message");
        OPTIONS.addOption("v", "version", false, "Print the version information and exit");
        OPTIONS.addOption("d", "debug", false, "Enable debug mode");

        try {
            commandLine = parser.parse(OPTIONS, args);
            if (commandLine.hasOption("h")) {

            }
        }catch (Exception e) {

            e.printStackTrace();
        }

    }


}
