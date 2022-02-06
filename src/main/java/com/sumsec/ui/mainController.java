package com.sumsec.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

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

    @FXML
    private ImageView CFGImageView;

    @FXML
    private ImageView ASTImageView;













    @FXML
    private void initialize() {
    }

    // 选择class文件
    public void CFGFile(ActionEvent actionEvent) {
    }
    // 生成cfg的dot文件
    public void CFGG(ActionEvent actionEvent) {
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
    }
}
