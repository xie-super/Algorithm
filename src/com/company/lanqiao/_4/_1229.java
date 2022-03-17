package com.company.lanqiao._4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/9
 * Name:IntelliJ IDEA
 */
public class _1229 {
    private static final int N = 3;
    static String[] result = new String[3];
    static String[] sp = new String[N];
    static int[] months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static String[] judge(String year, String month, String day){
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);

        if(y>=60&&y<=99){
            year = "19"+year;
        }else {
            year = "20"+year;
        }
        y = Integer.parseInt(year);
        String[] s = new String[2];
        s[0] = year;
        s[1] = "0";
        if(m>=13){return s;}
        if(d == 0){return s;}
        if(m!=2){
            if(d>months[m]){return s;}
        }else {
            if(y%4==0&&y%100!=0 || y%400==0){
                if(d>29){return s;}

            }else {
                if(d>28){return s;}
            }
        }
        s[1]="1";
        return s;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for(int i = 0; i<3; i++){
            result[i] = "";
        }
         sp= input.nextLine().split("/");
        String[] res = new String[2];
        res = judge(sp[0], sp[1], sp[2]);
        String r1 = null, r2=null, r3=null;

        if(res[1].equals("1")){

           r1 =  res[0]+"-"+sp[1]+"-"+sp[2];
           result[0] += r1;

        }
        result[0]+=" ";

        res = judge(sp[2], sp[0], sp[1]);

        if(res[1].equals("1")){
            r2 = res[0]+"-"+sp[0]+"-"+sp[1];
            result[1] += r2;
        }
        result[1]+=" ";
        res = judge(sp[2], sp[1], sp[0]);


        if(res[1].equals("1")){

            r3 = res[0]+"-"+sp[1]+"-"+sp[0];
            result[2] += r3;
        }
        result[2]+=" ";
        Arrays.sort(result);

        for(int i = 0; i<3; i++){
                if(result[i].length()>1) {
                    if(result[0].equals(result[1])&& result[1].equals(result[2])){
                        System.out.println(result[0]);
                        return;
                    }
                    if(result[0].equals(result[1]) && result[0].length()>1){
                        System.out.println(result[0]);
                        System.out.println(result[2]);
                        return;

                    }
                    if(result[1].equals(result[2]) && result[1].length()>1){
                        System.out.println(result[0]);
                        System.out.println(result[1]);
                        return;
                    }
                    System.out.println(result[i]);
                }


        }






    }
}
