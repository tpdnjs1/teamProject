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
        int idx = list.getSelectionModel().getSelectedIndex();
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

        setCalendar();

        addAllDiaryList();

        dDay();
    }

    public void addDiaryList(String title, Date dDay, String text) {
        DiaryList diaryList = new DiaryList(title, dDay, text);
        items.add(diaryList);
    }

    private void deleteList() {
        if (items.size() != 0) {
            while (items.size() != 0) {
                items.remove(0);
            }
        }
    }

    private void addAllDiaryList() {
        deleteList();

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

    @FXML
    private void B1() {
        deleteList();
        if (B1.getText() != "") {
            day = Integer.parseInt(B1.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B2() {
        deleteList();
        if (B2.getText() != "") {
            day = Integer.parseInt(B2.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B3() {
        deleteList();
        if (B3.getText() != "") {
            day = Integer.parseInt(B3.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B4() {
        deleteList();
        if (B4.getText() != "") {
            day = Integer.parseInt(B4.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B5() {
        deleteList();
        if (B5.getText() != "") {
            day = Integer.parseInt(B5.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B6() {
        deleteList();
        if (B6.getText() != "") {
            day = Integer.parseInt(B6.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B7() {
        deleteList();
        if (B7.getText() != "") {
            day = Integer.parseInt(B7.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B8() {
        deleteList();
        if (B8.getText() != "") {
            day = Integer.parseInt(B8.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B9() {
        deleteList();
        if (B9.getText() != "") {
            day = Integer.parseInt(B9.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B10() {
        deleteList();
        if (B10.getText() != "") {
            day = Integer.parseInt(B10.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B11() {
        deleteList();
        if (B11.getText() != "") {
            day = Integer.parseInt(B11.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B12() {
        deleteList();
        if (B12.getText() != "") {
            day = Integer.parseInt(B12.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B13() {
        deleteList();
        if (B13.getText() != "") {
            day = Integer.parseInt(B13.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B14() {
        deleteList();
        if (B14.getText() != "") {
            day = Integer.parseInt(B14.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B15() {
        deleteList();
        if (B15.getText() != "") {
            day = Integer.parseInt(B15.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B16() {
        deleteList();
        if (B16.getText() != "") {
            day = Integer.parseInt(B16.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B17() {
        deleteList();
        if (B17.getText() != "") {
            day = Integer.parseInt(B17.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B18() {
        deleteList();
        if (B18.getText() != "") {
            day = Integer.parseInt(B18.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B19() {
        deleteList();
        if (B19.getText() != "") {
            day = Integer.parseInt(B19.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B20() {
        deleteList();
        if (B20.getText() != "") {
            day = Integer.parseInt(B20.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B21() {
        deleteList();
        if (B21.getText() != "") {
            day = Integer.parseInt(B21.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B22() {
        deleteList();
        if (B22.getText() != "") {
            day = Integer.parseInt(B22.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B23() {
        deleteList();
        if (B23.getText() != "") {
            day = Integer.parseInt(B23.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B24() {
        deleteList();
        if (B24.getText() != "") {
            day = Integer.parseInt(B24.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B25() {
        deleteList();
        if (B25.getText() != "") {
            day = Integer.parseInt(B25.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B26() {
        deleteList();
        if (B26.getText() != "") {
            day = Integer.parseInt(B26.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B27() {
        deleteList();
        if (B27.getText() != "") {
            day = Integer.parseInt(B27.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B28() {
        deleteList();
        if (B28.getText() != "") {
            day = Integer.parseInt(B28.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B29() {
        deleteList();
        if (B29.getText() != "") {
            day = Integer.parseInt(B29.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B30() {
        deleteList();
        if (B30.getText() != "") {
            day = Integer.parseInt(B30.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B31() {
        deleteList();
        if (B31.getText() != "") {
            day = Integer.parseInt(B31.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B32() {
        deleteList();
        if (B32.getText() != "") {
            day = Integer.parseInt(B32.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B33() {
        deleteList();
        if (B33.getText() != "") {
            day = Integer.parseInt(B33.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B34() {
        deleteList();
        if (B34.getText() != "") {
            day = Integer.parseInt(B34.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B35() {
        deleteList();
        if (B35.getText() != "") {
            day = Integer.parseInt(B35.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B36() {
        deleteList();
        if (B36.getText() != "") {
            day = Integer.parseInt(B36.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B37() {
        deleteList();
        if (B37.getText() != "") {
            day = Integer.parseInt(B37.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B38() {
        deleteList();
        if (B38.getText() != "") {
            day = Integer.parseInt(B38.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B39() {
        deleteList();
        if (B39.getText() != "") {
            day = Integer.parseInt(B39.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B40() {
        deleteList();
        if (B40.getText() != "") {
            day = Integer.parseInt(B40.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B41() {
        deleteList();
        if (B41.getText() != "") {
            day = Integer.parseInt(B41.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
    }

    @FXML
    private void B42() {
        deleteList();
        if (B42.getText() != "") {
            day = Integer.parseInt(B42.getText());
            stDay = year + "-" + month + "-" + day;
            setList("SELECT * FROM `diary` WHERE `uid` = " + movePage.getUid() + " and LEFT(date,10) = DATE_FORMAT(now(), '" + stDay + "')");
        }
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