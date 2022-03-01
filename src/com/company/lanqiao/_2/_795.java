package com.company.lanqiao._2;

import com.sun.xml.internal.bind.v2.runtime.SwaRefAdapter;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/2/28
 * Name:795. 前缀和
 */
public class _795 {


    private static final int N = 100010;
    static int[] array = new int[N];
    static int[] sum = new int[N];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int q = scanner.nextInt();

        Arrays.fill(sum, 0);
        Arrays.fill(array, 0);

        for(int i = 1; i<=num; i++){
            array[i] = scanner.nextInt();

            sum[i] = sum[i-1]+array[i];

        }

        for(int i = 0; i<q; i++){

            int l = scanner.nextInt();
            int r =scanner.nextInt();

            array[i] = sum[r] - sum[l-1];


        }
        for(int i = 0; i<q; i++){
            System.out.println(array[i]);

        }


    }
}
