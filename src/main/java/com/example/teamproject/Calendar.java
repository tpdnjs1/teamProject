package com.example.teamproject;

public class Calendar {

    private static int getDate(int year, int month) {
        int tmp = 0;


        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                tmp = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                tmp = 30;
                break;
            case 2:
                tmp = 29;
                break;
        }

        return tmp;
    }

    //해당 월의 첫번쨰 요일 계산
    private static int getDayOfWeek(int year, int month) {
        int dayOfWeek = 0;
        int sum = 0;

        // 1.1.1 ~ year-1.12.31
        for (int i = 1; i < year; i++) {
            for (int j = 1; j <= 12; j++) {
                sum += getDate(i, j);
            }
        }

        //year.1.1 ~ year.month-1.마지막(31,30.29.28)
        for (int k = 1; k < month; k++) {
            sum += getDate(year, k);
        }

        //year.month.1일
        sum += 1;

        //요일
        dayOfWeek = sum % 7;

        return dayOfWeek;
    }

    public static void prn(int year, int month) {
        //달력 윗부분 출력
        System.out.printf("\t\t%d년 %d월\n", year, month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

        //시작 요일
        int start = Calendar.getDayOfWeek(year, month);

        //마지막 날짜
        int last = getDate(year, month);

        //시작 요일만큼 빈공간
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
        }
    }
}
