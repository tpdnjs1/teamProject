package com.example.teamproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
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
    public ListView<DiaryList> list;

    public ObservableList<DiaryList> items;

    private int idx;

    @FXML
    private Button confirmBtn;

    private String stTitle;
    private String stText;

    public String getStTitle() {
        return stTitle;
    }

    public String getStText() {
        return stText;
    }

    @FXML
    private void confirm() {
        idx = list.getSelectionModel().getSelectedIndex();
        if (idx >= 0) {
            stTitle = list.getSelectionModel().getSelectedItem().getTitle();
            stText = list.getSelectionModel().getSelectedItem().getStText();
            movePage.popUp("Diary", confirmBtn);
        } else {
            alert("일기를 선택해주세요.", null);
        }
    }


    @FXML
    private ToggleGroup date = new ToggleGroup();

    LocalDate now;
    int year;
    int month;
    int day;
    String stDay;
    String stMonth;

    DBUtil db = new DBUtil();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items = FXCollections.observableArrayList();
        list.setItems(items);

        now = LocalDate.now();
        year = now.getYear();
        month = now.getMonthValue();
        day = now.getDayOfMonth();
        stDay = year + "-" + month + "-" + day;

        setCalendar();

        addAllDiaryList();

        dDay();
    }

    public void addDiaryList(String title, Date dDay, String text) {
        DiaryList diaryList = new DiaryList(title, dDay, text);
        items.add(diaryList);
    }


    private void addAllDiaryList() {
        if (items.size() != 0) {
            while (items.size() != 0) {
                items.remove(0);
            }
        }

        stMonth = year + "-" + month;

        setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,7) = DATE_FORMAT(now(), '" + stMonth + "')");
    }

    private void setList(String sql) {
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaryList diaryList = new DiaryList(rs.getString("title"), rs.getDate("date"), rs.getString("text"));
                items.add(diaryList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void lastMonth() {
        month--;
        if (month < 1) {
            year--;
            month = 12;
        }
        setCalendar();
        addAllDiaryList();
    }

    @FXML
    private void nextMonth() {
        month++;
        if (month > 12) {
            year++;
            month = 1;
        }
        setCalendar();
        addAllDiaryList();
    }


    private final int BNUM1 = 1;
    private final int BNUM2 = 2;
    private final int BNUM3 = 3;
    private final int BNUM4 = 4;
    private final int BNUM5 = 5;
    private final int BNUM6 = 6;
    private final int BNUM7 = 7;
    private final int BNUM8 = 8;
    private final int BNUM9 = 9;
    private final int BNUM10 = 10;
    private final int BNUM11 = 11;
    private final int BNUM12 = 12;
    private final int BNUM13 = 13;
    private final int BNUM14 = 14;
    private final int BNUM15 = 15;
    private final int BNUM16 = 16;
    private final int BNUM17 = 17;
    private final int BNUM18 = 18;
    private final int BNUM19 = 19;
    private final int BNUM20 = 20;
    private final int BNUM21 = 21;
    private final int BNUM22 = 22;
    private final int BNUM23 = 23;
    private final int BNUM24 = 24;
    private final int BNUM25 = 25;
    private final int BNUM26 = 26;
    private final int BNUM27 = 27;
    private final int BNUM28 = 28;
    private final int BNUM29 = 29;
    private final int BNUM30 = 30;
    private final int BNUM31 = 31;
    private final int BNUM32 = 32;
    private final int BNUM33 = 33;
    private final int BNUM34 = 34;
    private final int BNUM35 = 35;
    private final int BNUM36 = 36;
    private final int BNUM37 = 37;
    private final int BNUM38 = 38;
    private final int BNUM39 = 39;
    private final int BNUM40 = 40;
    private final int BNUM41 = 41;
    private final int BNUM42 = 42;

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
    @FXML
    private ToggleButton B36;
    @FXML
    private ToggleButton B37;
    @FXML
    private ToggleButton B38;
    @FXML
    private ToggleButton B39;
    @FXML
    private ToggleButton B40;
    @FXML
    private ToggleButton B41;
    @FXML
    private ToggleButton B42;

    private void setCalendar() {
        prn(year, month, B1, BNUM1);
        prn(year, month, B2, BNUM2);
        prn(year, month, B3, BNUM3);
        prn(year, month, B4, BNUM4);
        prn(year, month, B5, BNUM5);
        prn(year, month, B6, BNUM6);
        prn(year, month, B7, BNUM7);
        prn(year, month, B8, BNUM8);
        prn(year, month, B9, BNUM9);
        prn(year, month, B10, BNUM10);
        prn(year, month, B11, BNUM11);
        prn(year, month, B12, BNUM12);
        prn(year, month, B13, BNUM13);
        prn(year, month, B14, BNUM14);
        prn(year, month, B15, BNUM15);
        prn(year, month, B16, BNUM16);
        prn(year, month, B17, BNUM17);
        prn(year, month, B18, BNUM18);
        prn(year, month, B19, BNUM19);
        prn(year, month, B20, BNUM20);
        prn(year, month, B21, BNUM21);
        prn(year, month, B22, BNUM22);
        prn(year, month, B23, BNUM23);
        prn(year, month, B24, BNUM24);
        prn(year, month, B25, BNUM25);
        prn(year, month, B26, BNUM26);
        prn(year, month, B27, BNUM27);
        prn(year, month, B28, BNUM28);
        prn(year, month, B29, BNUM29);
        prn(year, month, B30, BNUM30);
        prn(year, month, B31, BNUM31);
        prn(year, month, B32, BNUM32);
        prn(year, month, B33, BNUM33);
        prn(year, month, B34, BNUM34);
        prn(year, month, B35, BNUM35);
        prn(year, month, B36, BNUM36);
        prn(year, month, B37, BNUM37);
        prn(year, month, B38, BNUM38);
        prn(year, month, B39, BNUM39);
        prn(year, month, B40, BNUM40);
        prn(year, month, B41, BNUM41);
        prn(year, month, B42, BNUM42);


        yearLabel.setText(year + "");
        monthLabel.setText(month + "");
    }

    // * 캘린더 연말 디데이 구현
    @FXML
    private Label DdayLabel;

    public void dDay() {
        LocalDate fromDate = LocalDate.now();
        LocalDate toDate = LocalDate.of(2022, 12, 31);
        DdayLabel.setText("D - " + Duration.between(fromDate.atStartOfDay(), toDate.atStartOfDay()).toDays());

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