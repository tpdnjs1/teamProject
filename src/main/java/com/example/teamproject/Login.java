package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Login implements Initializable {

    MovePage movePage = new MovePage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField loginId;
    @FXML
    private PasswordField loginPw;
    @FXML
    private Button loginBtn;
    @FXML
    private Label signUpLabel;

    String id;
    String pw;

    // id, pw 존재하는지 데이터 베이스에서 조회
    public void changeToMain() {
        String getID = loginId.getText();
        String getPW = Login.this.loginPw.getText();
        DBUtil db = new DBUtil();
        Connection con = db.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from Users WHERE id = '" + getID + "'";

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String dataID = rs.getString("id");
                String dataPW = rs.getString("pw");

                id = dataID;
                pw = dataPW;

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        //id, pw TextField 입력 확인
        if(getID.equals(id)) {
            if(getPW.equals(pw)) {
                //화면 넘김
                movePage.changeScene("Main", loginBtn);
            }else {
                //비밀번호 불일치시 나오는 알람
                alert("비밀번호를 다시 입력해주세요.", null);
            }
        }else {
            //아이디 불일치시 나오는 알람
            alert("아이디를 다시 입력해주세요.", null);
        }

    }

    // 알림창 띄우기
    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }

    // sigh-up 화면으로 이동하는 라벨

    public void changeToSignUp(){
        movePage.changeSceneLabel("SignUp", signUpLabel);
    }

}