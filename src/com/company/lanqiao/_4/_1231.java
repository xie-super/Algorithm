package com.company.lanqiao._4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/9
 * Name:1231. 航班时间
 */
public class _1231 {

    public static void main(String[] args) throws Exception {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        Scanner input = new Scanner(System.in);
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =Integer.parseInt(reader.readLine());

        for(int ix = 0; ix<n; ix++) {


            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String s1 = "", s2 = "", e1 = "", e2 = "";
            int num = 0;//天数
            if (line1.contains("(+")) {
                num = Integer.parseInt((line1.split(" ")[2]).substring(2, 3));
            }
            s1 = line1.split(" ")[0];
            e1 = line1.split(" ")[1];
            num = Integer.parseInt(e1.substring(0, 2)) + num * 24;
            if(num<10){
                e1 = "0"+String.valueOf(num) + e1.substring(2, 8);
            }else {
                e1 = String.valueOf(num) + e1.substring(2, 8);
            }
            num = 0;
            if (line2.contains("(+")) {
                num = Integer.parseInt((line2.split(" ")[2]).substring(2, 3));
            }
            s2 = line2.split(" ")[0];
            e2 = line2.split(" ")[1];

            num = Integer.parseInt(e2.substring(0, 2)) + num * 24;
            if(num<10){
                e2 = "0" + String.valueOf(num) + e2.substring(2, 8);
            }else {
                e2 = String.valueOf(num) + e2.substring(2, 8);
            }

            int sumES = Integer.parseInt(e2.substring(6, 8)) + Integer.parseInt(e1.substring(6, 8));
            int sumEM = Integer.parseInt(e2.substring(3, 5)) + Integer.parseInt(e1.substring(3, 5));
            int sumEH = Integer.parseInt(e2.substring(0, 2)) + Integer.parseInt(e1.substring(0, 2));


            int sumSS = Integer.parseInt(s2.substring(6, 8)) + Integer.parseInt(s1.substring(6, 8));
            int sumSM = Integer.parseInt(s2.substring(3, 5)) + Integer.parseInt(s1.substring(3, 5));
            int sumSH = Integer.parseInt(s2.substring(0, 2)) + Integer.parseInt(s1.substring(0, 2));


            int resS = sumES - sumSS;
            while (true){
                if (resS < 0) {
                    sumEM--;
                    resS += 60;
                }
                else {
                    break;
                }
            }

            int resM = sumEM - sumSM;
            while(true) {
                if (resM < 0) {
                    sumEH--;
                    resM += 60;
                }else {
                    break;
                }
            }
            int resH = sumEH - sumSH;
            String result = "";
            if (resH % 2 != 0) {
                resH--;
                resM += 60;
            }
            resH /= 2;

            if (resM % 2 != 0) {
                resM--;
                resS += 60;
            }
            resM /= 2;


            resS /= 2;


            if(resS>60){
                resS-=60;
                resM++;
            }
            if(resM>60){
                resM-=60;
                resH++;
            }
            if (resH < 10) {

                result = result + "0" + resH;
            } else {
                result += resH;
            }
            result += ":";
            if (resM < 10) {
                result = result + "0" + resM;
            } else {
                result += resM;
            }
            result += ":";
            if (resS < 10) {
                result = result + "0" + resS;
            } else {
                result += resS;
            }

            writer.write(result+"\n");


        }



        writer.flush();
        writer.close();
        reader.close();

    }
}
