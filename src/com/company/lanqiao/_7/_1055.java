package com.company.lanqiao._7;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/31
 * Name:1055. 股票买卖 II
 */
public class _1055 {
    private static final int N = 100010;
    static int[] a = new int[N];
    static int n;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        long sum = 0;
        for(int i = 0; i<n; i++){
            a[i] = input.nextInt();
        }
        for(int i = 1; i<n; i++){
            if(a[i]>a[i-1]){
                sum+=(a[i]-a[i-1]);
            }
        }

        System.out.println(sum);

    }
}
