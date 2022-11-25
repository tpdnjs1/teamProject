package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class DiaryAdd {
    MovePage movePage = new MovePage();
    Main main = new Main();

    @FXML
    private TextField title;
    @FXML
    private TextArea text;
    @FXML
    private Button addBtn;

    @FXML
    private void add(){
        if (title.getText().length() > 20){
            alert("제목은 20자를 넘을 수 없습니다.", null);
            return;
        }

        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO `diary`(`uid`, `title`, `text`, `date`) VALUES (?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movePage.getUid());
            pstmt.setString(2, title.getText());
            pstmt.setString(3, text.getText());
            pstmt.setDate(4, Date.valueOf(LocalDate.now()));
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

        Stage pop = (Stage) addBtn.getScene().getWindow();
        pop.close();
    }

    // 알림창 띄우기
    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }
}
