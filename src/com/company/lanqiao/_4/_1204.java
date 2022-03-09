package com.company.lanqiao._4;

import java.io.*;
import java.util.*;


/**
 * Author:xie-super
 * Time:2022/3/7
 * Name:1204. 错误票据
 * Method:枚举
 */
public class _1204 {
    private static final int N = 100010;
    static Integer[] a = new Integer[N];
    static int[] cnt = new int[N];
    static int n;
    static BufferedReader  reader= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer  =new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(reader.readLine());
        int index = 0;
        for(int i  =0; i<N; i++){
            a[i] = 0;
        }
        int min = N;
       for(int i = 0; i<n; i++){
           String[] sp = reader.readLine().split(" ");
           for(int j = 0; j<sp.length; j++){
               a[index] = Integer.parseInt(sp[j]);
               min = Math.min(min, a[index]);
               cnt[a[index++]]++;
           }


       }
       Arrays.sort(a);


        int flag  = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        int res1 = 0;
        int res2 = 0;
        for(int ix = min; ix<N; ix++){

            if(cnt[ix]==0 && !flag1){
                res1 = ix;
                flag1 = true;
            }else if(cnt[ix]>1 && !flag2){
                res2 = ix;
                flag2 = true;
            }

        }

        System.out.print(res1+" "+res2);


    }
}
