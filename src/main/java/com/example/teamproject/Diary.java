package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class Diary implements Initializable {
    @FXML
    private String title;
    @FXML
    private String stText;
    private Date date;

    String Tt;
    String De;




    public Diary(String title, Date date, String stText) {
        this.title = title;
        this.stText = stText;
        this.date = date;
    }

    public void SelectDiary() {
        String getTitle = title.getText();
        String getDetail = Diary.this.stText.getText();
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from Users WHERE id = '" + getTitle + "'";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                String dataTitle = rs.getString("title");
                String dataDetail = rs.getString("text");

                Tt = dataTitle;
                De = dataDetail;


                MovePage.setUid(rs.getString("uid"));

            }
        } catch (Exception e) {

        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public Date getDate () {
            return date;
        }

        public void setDate (Date date){
            this.date = date;
        }

        public String getStText () {
            return stText;
        }

        public void setStText (String text){
            this.stText = text;
        }

        @Override
        public String toString () {
            return "" + date + " : " + title;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
