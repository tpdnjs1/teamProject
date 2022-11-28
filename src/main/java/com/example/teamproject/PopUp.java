package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopUp {
    MovePage movePage = new MovePage();

    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private Button save;

    @FXML
    private void changeCon(){
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql;

        if (name.getText() != null){
            sql = "UPDATE `users` SET `name`=? WHERE `uid` =" + movePage.getUid();
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name.getText());
                pstmt.executeUpdate();
                alert("정상적으로 이름이 수정되었습니다.", null);
            } catch (SQLException e) {
                alert("정상적으로 이름이 수정되지 못했습니다.", null);
            }
        }
        if (password.getText() != null){
            sql = "UPDATE `users` SET `pw`= ? WHERE `uid` =" + movePage.getUid();
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, password.getText());
                pstmt.executeUpdate();
                alert("정상적으로 비밀번호가 수정되었습니다.", null);
            } catch (SQLException e) {
                alert("정상적으로 비밀번호가 수정되지 못했습니다.", null);
            }
        }


    }

    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }
}
