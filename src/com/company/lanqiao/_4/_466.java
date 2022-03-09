package com.company.lanqiao._4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/7
 * Name:466. 回文日期
 * Method: 枚举,主要是知道闰年二月的判定方法， mongth%4==0 && month%100!=0 || month % 400 ==0
 */
public class _466 {
    public static int[] month = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    static String start;
    static String end;
    public static boolean check(int year){
        String s = String.valueOf(year);
        String rs = new StringBuilder(s).reverse().toString();

        int months = Integer.parseInt(rs.substring(0,2));
        int day = Integer.parseInt(rs.substring(2,4));

        if(months>=13) return false;
        if(day==0){return false;}
        if(months!=2) {
            if (day > month[months]) {
                return false;
            }
        }
            if(months == 2){
                if(year%4 ==0 && year%100 !=0 || year % 400 ==0){
                    if(day>29){
                        return false;
                    }
                }else {
                    if(day>28){
                        return false;
                    }
                }

        }
        return true;



    }
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
         start = input.nextLine();
          end = input.nextLine();
        int res = 0;
        int startYear = Integer.parseInt(start.substring(0,4));
        int endYear = Integer.parseInt(end.substring(0,4));

        for(int i =startYear; i<endYear; i++){
            if(check(i)){
                res++;
            }
        }
        if(check(endYear)){
            String s = String.valueOf(endYear);
            String rs = new StringBuilder(s).reverse().toString();
            s+=rs;
            int midVal = Integer.parseInt(s);
            if(midVal<=Integer.parseInt(end)&& midVal>=Integer.parseInt(start)){
                res++;
            }
        }
        System.out.println(res);


    }
}
