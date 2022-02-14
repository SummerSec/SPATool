package com.sumsec.ui;


import com.sumsec.core.ast.Parser;
import com.sumsec.core.ast.util.ASTSave;
import com.sumsec.core.ast.util.FindFile;
import com.sumsec.core.ast.util.JavaContent;
import com.sumsec.core.cfg.Generate;
import com.sumsec.core.cfg.ImageUtil;
import com.sumsec.core.cfg.uitls.SelectC;
import com.sumsec.util.ConstatField;
import com.sumsec.util.SaveFile;
import com.sumsec.util.SelectFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static cn.hutool.core.io.FileUtil.mkdir;

/**
 * @ClassName: mainController
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/4 13:22
 * @Version: v1.0.0
 * @Description:
 **/
public class mainController {

    public static String CFGFilePath = "";
    // 选择类文件位置
    public static String CFGFileName = "";
    // 选择类文件明

    public static File ASTFiles;
    // 选择Java文件位置
    public static String ASTFileName = null;
    // 选择Java文件名字

    @FXML
    public TextArea mC; // 方法内容
    @FXML
    public TextField mName; // 方法名
    @FXML
    public ComboBox<String> graphType; // 类型
    @FXML
    public ComboBox<String> FileType; // ast type

    @FXML
    public TextArea ASTFC; // ast





    private static Logger log = LogManager.getLogger(mainController.class);


    @FXML
    private void initialize() {
        this.init();
        this.InitCombox();
        ControllersFactory.controllers.put(mainController.class.getName(), this);

    }

    // 选择class文件
    public void CFGFile(ActionEvent actionEvent) {
        log.info("选择class文件");
        SelectFile selectFile = new SelectFile();
        File file = selectFile.SelectFile();
        CFGFileName = file.getName();
        CFGFilePath = file.getAbsolutePath();
        log.info("选择的文件名为：" + CFGFileName);
        log.info("选择的文件路径为：" + CFGFilePath);
    }
    // 生成cfg的dot文件
    public void CFGG(ActionEvent actionEvent) {
        if (!ConstatField.flag1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("请重新打开程序在使用生成CFG功能模块！");
            alert.show();
        }
        Generate generate = new Generate();
        boolean f = false;
        if (!CFGFilePath.equals("")) {
            SelectC.selectFile(CFGFilePath,CFGFileName);
            f = generate.DotG(graphType.getValue(),CFGFileName);
            CFGFileName = "";
            CFGFilePath = "";

        }else {
//            String methodN = mName.getText();
            String mContext = mC.getText();
//            System.out.println(methodN);
            System.out.println(mContext);
            if (!mContext.equals("")) {
                String clzzname = generate.methodG("methodN", mContext);
                f = generate.DotG(graphType.getValue(), clzzname);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("请输入方法名和方法内容");
                alert.show();
                System.out.println("请输入方法名和方法内容");
            }
        }
        if (!f) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setContentText("Something wrong, Please looking the log file");
        }else {
            log.info("生成cfg的dot文件成功");
            ImageUtil imageUtil = new ImageUtil();
            String[] path = imageUtil.Dot2Image();
            imageUtil.setImage(path);
        }

    }

    // 保存CFG的dot文件
    public void CFGSFile(ActionEvent actionEvent) {
        SaveFile saveFile = new SaveFile();
        saveFile.Save("dot",true);
    }
    // 导出CFG图片
    public void CFGExport(ActionEvent actionEvent) {
       SaveFile saveFile = new SaveFile();
       saveFile.Save("png",true);
    }
    // 生成AST文件
    public void ASTG(ActionEvent actionEvent) {
        String context = ASTFC.getText();
        Parser parser = new Parser();
        if (!context.equals("")) {
            log.info("输入的内容为：" + context);
            parser.parse(context,"DOT",true);
        }else if (ASTFiles.exists()){
            log.info("正在读取文件");
            context = JavaContent.ReadJavaContent(ASTFiles);
            parser.parse(context,"DOT",true);
        }else {
            log.info("请输入文件内容，或者选择文件");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("请输入文件内容，或者选择文件");
            alert.show();
        }
    }
    // 保存AST文件
    public void ASTSave(ActionEvent actionEvent) {
        SaveFile saveFile = new SaveFile();
        saveFile.Save(FileType.getValue().toLowerCase(),false);
    }
    // 导出AST图片
    public void ASTExport(ActionEvent actionEvent) {
        SaveFile saveFile = new SaveFile();
        saveFile.Save("png",false);
    }
    // 清空文件输入框
    public void ASTReset(ActionEvent actionEvent) {
        ASTFC.setText("");
        ASTFiles = null;
        ASTFileName = "";
    }
    // 选择Java或者Class文件
    public void ASTFile(ActionEvent actionEvent) {
        SelectFile selectFile = new SelectFile();
        ASTFiles = selectFile.SelectFile();
        ASTFileName = ASTFiles.getName();
        log.info("选择的文件名为：" + ASTFileName);
        log.info("选择的文件路径为：" + ASTFiles.getAbsolutePath());

    }

    public void InitCombox(){
        ObservableList<String> graphs = FXCollections.observableArrayList(new String[]{"BriefUnitGraph","ExceptionalUnitGraph","CompleteUnitGraph",
        "TrapUnitGraph","ClassicCompleteUnitGraph","BriefBlockGraph","ExceptionalBlockGraph","CompleteBlockGraph","ClassicCompleteBlockGraph","ArrayRefBlockGraph",
        "ZonedBlockGraph","AltArrayRefBlockGraph","AltBriefUnitGraph","AltCompleteUnitGraph","AltTrapUnitGraph","AltBriefBlockGraph","AltCompleteBlockGraph","AltZonedBlockGraph"});
        this.graphType.setPromptText("BriefUnitGraph");
        this.graphType.setValue("BriefUnitGraph");
        this.graphType.setItems(graphs);
        ObservableList<String> astTypes = FXCollections.observableArrayList(new String[]{"DOT", "JSON", "YAML","XML"});
        this.FileType.setValue("DOT");
        this.FileType.setPromptText("DOT");
        this.FileType.setItems(astTypes);
    }
    public void init(){
        ConstatField.CFGHOMETemp = ConstatField.CFGHOME +  ConstatField.separator + System.nanoTime();
        ConstatField.ResultTemp = ConstatField.ResultTemp + ConstatField.separator + System.nanoTime();
        ConstatField.sootOutputTemp = ConstatField.sootOutput + ConstatField.separator + System.nanoTime();
        ConstatField.ASTHomeTemp = ConstatField.ASTHome + ConstatField.separator + System.nanoTime();
        ConstatField.ASTResultTemp = ConstatField.ASTResult + ConstatField.separator + System.nanoTime();
        mkdir(ConstatField.CFGHOMETemp);
        mkdir(ConstatField.ResultTemp);
        mkdir(ConstatField.sootOutputTemp);
        mkdir(ConstatField.ASTHomeTemp);
        mkdir(ConstatField.ASTResultTemp);
        log.info("初始化成功");
        log.info("CFG文件存储路径为：" + ConstatField.CFGHOMETemp);
        log.info("AST文件存储路径为：" + ConstatField.ASTHomeTemp);
        log.info("结果文件存储路径为：" + ConstatField.ResultTemp);
        log.info("soot输出文件存储路径为：" + ConstatField.sootOutputTemp);
        log.info("ASTResultTemp：" + ConstatField.ASTResultTemp);
    }
}
