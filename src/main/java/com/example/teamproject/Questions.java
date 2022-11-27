package com.example.teamproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class Questions implements Initializable {

    MovePage movePage = new MovePage();
    Random random = new Random();

    @FXML
    private Button main;
    @FXML
    private Button question;
    @FXML
    private Button setting;

    @FXML
    private TextArea answer;

    @FXML
    private Label qNUm;
    @FXML
    private Label qChange;

    @FXML
    private void moveMain(){movePage.changeScene("Main", main);}
    @FXML
    private void moveQuestion(){movePage.changeScene("Questions", question);}

    @FXML
    private void moveSetting(){movePage.changeScene("Setting", setting);}

    @FXML
    private ListView<QuList> list;
    private ObservableList<QuList> items;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items = FXCollections.observableArrayList();
        list.setItems(items);

        addQuList();
        newQu();
    }

    DBUtil db = new DBUtil();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private void addQuList(){
        if (items.size() != 0){
            while (items.size() != 0){
                items.remove(0);
            }
        }

        setList("SELECT * FROM `answers` WHERE `uid` =" + movePage.getUid());
    }

    private void setList(String sql){
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            for (int listNum = 1; rs.next(); listNum++){
                QuList quList = new QuList(listNum, rs.getString("qNum"), rs.getString("answer"), rs.getDate("date"));
                items.add(quList);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void newQu(){
        qNUm.setText((items.size()+1)+"th");

        String sql = "SELECT * FROM `questions` WHERE `qNum` = "+ (random.nextInt(100)+1);
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                qChange.setText(rs.getString("question"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addList(){
        
    }


}
