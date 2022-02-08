package com.sumsec.ui;

import com.sumsec.core.cfg.Generate;
import com.sumsec.core.cfg.ImageUtil;
import com.sumsec.core.cfg.uitls.GenClass;
import com.sumsec.core.cfg.uitls.SelectC;
import com.sumsec.uitl.ConstatField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.plaf.FileChooserUI;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

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
    public static String CFGSaveFilePath = "";
    // 保存cfg文件的位置
    public static String CFGImagePath = "";
    // 保存cfg图片的位置
    public static String ASTFileContext = "";
    // AST中 java文件内容
    public static String ASTFilePath = "";
    // AST 保存路径
    public String ASTImagePath = "";
    // AST 保存图片位置
    public String ASTFileName = "";
    // 保存AST文件名
//    public String GraphType = "";
    // graph type

    @FXML
    public TextArea mC; // 方法内容
    @FXML
    public TextField mName; // 方法名
    @FXML
    public ComboBox<String> graphType; // 类型
    @FXML
    public ComboBox<String> FileType; // ast type

    @FXML
    public ImageView CFGImageView;

    @FXML
    public ImageView ASTImageView;













    @FXML
    private void initialize() {
        ConstatField.CFGHOMETemp +=  ConstatField.separator + System.nanoTime();
        ConstatField.ResultTemp += ConstatField.separator + System.nanoTime();
        this.InitCombox();
        ControllersFactory.controllers.put(mainController.class.getName(), this);

    }

    // 选择class文件
    public void CFGFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Class Files", "*.class");
        fileChooser.getExtensionFilters().add(extFilter);
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        CFGFileName = file.getName();
        CFGFilePath = file.getAbsolutePath();

//        System.out.println(CFGFilePath);
//        System.out.println(classPath);

    }
    // 生成cfg的dot文件
    public void CFGG(ActionEvent actionEvent) {
        Generate generate = new Generate();
        boolean f = false;
//        generate.DotG();
        if (!CFGFilePath.equals("")) {
            SelectC.selectFile(CFGFilePath);
            f = generate.DotG(graphType.getValue(),CFGFileName);

        }else {
            String methodN = mName.getText();
            String mContext = mC.getText();
            System.out.println(methodN);
            System.out.println(mContext);
            if (!methodN.equals("") && !mContext.equals("")) {
                String clzzname = generate.methodG(methodN, mContext);
                f = generate.DotG(graphType.getValue(), clzzname);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("请输入方法名和方法内容");
                System.out.println("请输入方法名和方法内容");
            }
        }
        if (!f) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setContentText("Something wrong, Please looking the log file");
        }else {
            ImageUtil imageUtil = new ImageUtil();
            String path = imageUtil.Dot2Image(mName.getText());
            CFGImageView = new ImageView();
            imageUtil.setImage(path,CFGImageView);
        }
    }
    // 保存CFG的dot文件
    public void CFGSFile(ActionEvent actionEvent) {
    }
    // 导出CFG图片
    public void CFGExport(ActionEvent actionEvent) {
    }
    // 生成AST文件
    public void ASTG(ActionEvent actionEvent) {
    }
    // 保存AST文件
    public void ASTSave(ActionEvent actionEvent) {
    }
    // 导出AST图片
    public void ASTExport(ActionEvent actionEvent) {
    }
    // 清空文件输入框
    public void ASTReset(ActionEvent actionEvent) {
    }
    // 选择Java或者Class文件
    public void ASTFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Class Files", "*.class");
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Java Files", "*.java");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters().add(extFilter1);
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
    }

    public void InitCombox(){
        ObservableList<String> graphs = FXCollections.observableArrayList(new String[]{"BriefUnitGraph"});
        this.graphType.setPromptText("BriefUnitGraph");
        this.graphType.setValue("BriefUnitGraph");
        this.graphType.setItems(graphs);
        ObservableList<String> astTypes = FXCollections.observableArrayList(new String[]{"DOT", "JSON", "YAML"});
        this.FileType.setValue("DOT");
        this.FileType.setPromptText("DOT");
        this.FileType.setItems(astTypes);

    }
}
