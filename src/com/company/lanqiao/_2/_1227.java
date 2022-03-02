package com.company.lanqiao._2;

import java.io.*;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/1
 * Name:1227. 分巧克力
 */
public class _1227 {
    private static final int N = 100010;
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int n,k;
    public static boolean check(int l){
        int num = 0;
        for(int i = 0;i<n;i++){
            num+=(h[i]/l)*(w[i]/l);
            if(num>=k){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
         k = scanner.nextInt();

        for(int i = 0; i<n ;i++){

            h[i]= scanner.nextInt();
            w[i] = scanner.nextInt();

        }
        int r = 100010, l = 1;
        int result = 0;
       while(l<r){
           int mid = l + (r-l+1>>1);
           if(check(mid)){
               l = mid;
           }else {
               r = mid -1;
           }

       }
        System.out.println(r);




    }
}
