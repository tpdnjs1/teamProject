package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUp {
    MovePage movePage = new MovePage();

    @FXML
    private TextField id;
    @FXML
    private TextField pw;
    @FXML
    private TextField name;
    @FXML
    private Button joinBtn;
    @FXML
    private Label loginLabel;

    @FXML
    private void onMouse() {
        loginLabel.setUnderline(true);
    }

    @FXML
    private void offMouse() {
        loginLabel.setUnderline(false);
    }

    public void insertMember() {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;
        String sql = "INSERT INTO users(id, pw, name) VALUES(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id.getText());
            pstmt.setString(2, pw.getText());
            pstmt.setString(3, name.getText());
            pstmt.executeUpdate();
            alert("회원가입이 정상적으로 완료되었습니다.", null);

            //알트 확인 버튼 클릭되면 화면 전환 시키고싶음.

        } catch (Exception e) {
            alert("회원가입이 제대로 완료되지 않았습니다.", null);

        }
    }

    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }

    //  화면 전환 버튼 구현
    public void changeSceneToLogin() {
        movePage.changeSceneLabel("Login", loginLabel);
    }
}