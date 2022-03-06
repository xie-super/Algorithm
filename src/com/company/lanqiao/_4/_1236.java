package com.company.lanqiao._4;

import java.io.*;
import java.util.*;

import java.util.Comparator;

/**
 * Author:xie-super
 * Time:2022/3/6
 * Name:1236. 递增三元组
 * Method :枚举
 */
public class _1236 {
    private static final int N = 100010;
    static int[][] f = new int[N][2];
    static int[][] s = new int[N][2];
    static int[][] t = new int[N][2];
    static Integer[] a1 = new Integer[N];
    static Integer[] a2 = new Integer[N];
    static Integer[] a3 = new Integer[N];

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());

        String[] sp;
        for(int i = 0; i<3; i++){
            sp = reader.readLine().split(" ");
            for(int j = 0; j<n; j++){
                switch (i){
                    case 0:a1[j] = Integer.parseInt(sp[j]);
                    break;
                    case 1:a2[j] = Integer.parseInt(sp[j]);
                    break;
                    case 2:a3[j] = Integer.parseInt(sp[j]);
                    break;
                }
            }

          Arrays.sort(a1, 0, a1.length, new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                  return o1-o2;
              }
          });
          Arrays.sort(a2, 0, a2.length, new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                  return o1-o2;
              }
          });
          Arrays.sort(a3, 0, a3.length, new Comparator<Integer>(){
              @Override
              public int compare(Integer o1, Integer o2){
                  return o1 - o2;
              }
          });

        }

    }

}
