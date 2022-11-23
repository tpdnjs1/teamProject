package com.example.teamproject;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class Calendar {

    private static int getDate(int month) {
        int tmp = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 29;
            default -> 0;
        };

        return tmp;
    }

    //해당 월의 첫번째 요일 계산
    private static int getDayOfWeek(int year, int month) {
        int dayOfWeek;
        int sum = 1;

        // 1.1.1 ~ year-1.12.31
        for (int i = 1; i < year; i++) {
            for (int j = 1; j <= 12; j++) {
                sum += getDate(j);
            }
        }
        //year.1.1 ~ year.month-1.마지막(31,30.29.28)
        for (int k = 1; k < month; k++) {
            sum += getDate(k);
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
        int last = getDate(month);

        int day = bNum-start;

/*        //시작 요일만큼 빈공간
        for (int i = 1; i <= start; i++) {
            System.out.print("\t");
        }

        //달력출력
        for (int i = 1; i <= last; i++) {
            System.out.printf("%d\t", i);
            start++;
            if (start % 7 == 0) {
                System.out.println();
            }
        }*/

        if (start >= bNum || last < day){
            btn.setText(" ");
        } else {
            btn.setText(String.valueOf(day));
        }

    }


}
