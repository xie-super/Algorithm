package com.company.lanqiao._4;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/7
 * Name:1245. 特别数的和
 * Method: 枚举
 */
public class _1245 {
    static  int n;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        int res = 0;

        for(int i = 1; i<=n; i++){
            String s = String.valueOf(i);
            if(s.contains("0")|| s.contains("1")||s.contains("2")||s.contains("9")){
                res+=i;
            }
        }
        System.out.println(res);

    }

}
