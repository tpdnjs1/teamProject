package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.teamproject.Calendar.prn;

public class Main implements Initializable {

    MovePage movePage = new MovePage();
    @FXML
    private Button add;
    @FXML
    private Button main;
    @FXML
    private Button question;

    @FXML
    private Button setting;

    @FXML
    private void popUpPage() {
        movePage.popUp("DiaryAdd", add);
    }

    @FXML
    private void moveMain() {
        movePage.changeScene("Main", main);
    }

    @FXML
    private void moveQuestion() {
        movePage.changeScene("Questions", question);
    }

    @FXML
    private void moveSetting() {
        movePage.changeScene("Setting", setting);
    }



    @FXML
    private Label yearLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Button lastMonthBtn;
    @FXML
    private Button nextMonthBtn;
    @FXML
    private ToggleGroup date = new ToggleGroup();

    private int bNum1;
    private int bNum2;
    private int bNum3;
    private int bNum4;
    private int bNum5;
    private int bNum6;
    private int bNum7;
    private int bNum8;
    private int bNum9;
    private int bNum10;
    private int bNum11;
    private int bNum12;
    private int bNum13;
    private int bNum14;
    private int bNum15;
    private int bNum16;
    private int bNum17;
    private int bNum18;
    private int bNum19;
    private int bNum20;
    private int bNum21;
    private int bNum22;
    private int bNum23;
    private int bNum24;
    private int bNum25;
    private int bNum26;
    private int bNum27;
    private int bNum28;
    private int bNum29;
    private int bNum30;
    private int bNum31;
    private int bNum32;
    private int bNum33;
    private int bNum34;
    private int bNum35;
    @FXML
    private ToggleButton B1;
    @FXML
    private ToggleButton B2;
    @FXML
    private ToggleButton B3;
    @FXML
    private ToggleButton B4;
    @FXML
    private ToggleButton B5;
    @FXML
    private ToggleButton B6;
    @FXML
    private ToggleButton B7;
    @FXML
    private ToggleButton B8;
    @FXML
    private ToggleButton B9;
    @FXML
    private ToggleButton B10;
    @FXML
    private ToggleButton B11;
    @FXML
    private ToggleButton B12;
    @FXML
    private ToggleButton B13;
    @FXML
    private ToggleButton B14;
    @FXML
    private ToggleButton B15;
    @FXML
    private ToggleButton B16;
    @FXML
    private ToggleButton B17;
    @FXML
    private ToggleButton B18;
    @FXML
    private ToggleButton B19;
    @FXML
    private ToggleButton B20;
    @FXML
    private ToggleButton B21;
    @FXML
    private ToggleButton B22;
    @FXML
    private ToggleButton B23;
    @FXML
    private ToggleButton B24;
    @FXML
    private ToggleButton B25;
    @FXML
    private ToggleButton B26;
    @FXML
    private ToggleButton B27;
    @FXML
    private ToggleButton B28;
    @FXML
    private ToggleButton B29;
    @FXML
    private ToggleButton B30;
    @FXML
    private ToggleButton B31;
    @FXML
    private ToggleButton B32;
    @FXML
    private ToggleButton B33;
    @FXML
    private ToggleButton B34;
    @FXML
    private ToggleButton B35;

    private int daySum;

    LocalDate now = LocalDate.now();
    int year;
    int month;
    int day;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        year = now.getYear();
        month = now.getMonthValue();
        day = now.getDayOfMonth();
    }

    private void setCalendar(){
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
        prn(year, month, B1, bNum1);
    }
}