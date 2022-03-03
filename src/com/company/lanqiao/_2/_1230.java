package com.company.lanqiao._2;

import java.io.*;
import java.util.Scanner;

import java.io.*;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/3
 * Name:1230. K倍区间
 */
public class _1230 {
    private static final int N = (int) (1e5+10);
    public static int [] array = new int[N];
    static int [] sum =  new  int[N];
    static int[] cnt = new int[N];
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String []sp;
        sp = reader.readLine().split(" ");

        n = Integer.parseInt(sp[0]);
        k = Integer.parseInt(sp[1]);

        for(int i = 1;i<=n;i++ ){
            sp = reader.readLine().split(" ");
            array[i] = Integer.parseInt(sp[0])%k;

        }
        long count = 0;
        for(int i = 1; i<=n; i++){
            sum[i] =  sum[i-1]+array[i];
            sum[i]=sum[i]%k;
            if(sum[i]==0){count++;}
            int rest =sum[i];
            try{

                count+=cnt[rest];
                cnt[sum[i]]++;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(rest);
            }


        }
        String s = String.valueOf(count);
        writer.write(s);
        writer.flush();
        writer.close();
        reader.close();

    }
}
