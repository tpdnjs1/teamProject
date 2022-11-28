package com.example.teamproject;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class Calendar {

    //윤년 계산
    private static boolean isLeapYear(int year) {
        boolean leap = false;

        if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            leap = true;
        }
        return leap;
    }

    private static int getDate(int year, int month) {
        int tmp = 0;

        if(isLeapYear(year)) {

            switch(month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    tmp = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    tmp = 30;
                    break;
                case 2:
                    tmp = 29;
                    break;
            }
        }else {
            if(month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 || month == 12) {
                tmp = 31;
            } else if(month == 4 || month == 6 || month == 9 || month == 11) {
                tmp = 30;
            }else if (month == 2) {
                tmp = 28;
            }
        }
        return tmp;
    }
    //해당 월의 첫번쨰 요일 계산
    private static int getDayOfWeek(int year, int month) {
        int dayOfWeek = 0;
        int sum = 0;

        // 1.1.1 ~ year-1.12.31
        for(int i = 1; i < year; i++) {
            for(int j = 1; j <= 12; j++) {
                sum += getDate(i, j);
            }
        }

        //year.1.1 ~ year.month-1.마지막(31,30.29.28)
        for(int k = 1; k < month; k++) {
            sum += getDate(year, k);
        }

        //year.month.1일
        sum += 1;

        //요일
        dayOfWeek = sum % 7;

        return dayOfWeek;
    }

    public static void prn(int year, int month, ToggleButton btn, int bNum) {
        //시작 요일
        int start = getDayOfWeek(year, month);

        //마지막 날짜
        int last = getDate(year, month);

        int day = bNum-start;

        if (start >= bNum || last < day){
            btn.setText("");
        } else {
            btn.setText(String.valueOf(day));
        }

    }


}
