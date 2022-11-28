package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Setting implements Initializable {
    MovePage movePage = new MovePage();

    @FXML
    private Button main;
    @FXML
    private Button question;
    @FXML
    private Button setting;

    @FXML
    private Label signOut;
    @FXML
    private Label account;
    @FXML
    private Label name;

    @FXML
    private void moveMain(){movePage.changeScene("Main", main);}
    @FXML
    private void moveQuestion(){movePage.changeScene("Questions", question);}
    @FXML
    private void moveSetting(){movePage.changeScene("Setting", setting);}

    @FXML
    private void moveCorrection(){movePage.popUpLabel("PopUp",account);}
    @FXML
    private void moveSignOut() {
        movePage.popUpLabel("Login", signOut);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM `users` WHERE `uid` = " + movePage.getUid();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                name.setText(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




