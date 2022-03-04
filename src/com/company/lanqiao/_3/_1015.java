package com.company.lanqiao._3;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/3
 * Name:1015. 摘花生
 * Method:线性DP
 */
public class _1015 {
    private static final int N = 110;
    public static long[][] f = new long[N][N];
    //f(i,j)为
    public static int[][] v = new int[N][N];
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp;
        T = Integer.parseInt(reader.readLine());
        long[] result = new long[T];
        for(int t = 0; t<T; t++){
            sp = reader.readLine().split(" ");
            int r = Integer.parseInt(sp[0]);
            int c = Integer.parseInt(sp[1]);
            for(int i  = 1; i<=r; i++){
                sp = reader.readLine().split(" ");
                for(int j = 1; j<=c; j++){

                    v[i][j]  =  Integer.parseInt(sp[j-1]);
                    f[i][j] = Math.max(f[i][j-1]+v[i][j], f[i-1][j]+v[i][j]);
                }
            }

            result[t] = f[r][c];
            for(int i = 1; i<=r; i++){
                Arrays.fill(f[i], 0);
                Arrays.fill(v[i],0);
            }


        }
        for(int i = 0; i<T; i++){
            String s = String.valueOf(result[i]);
            writer.write(s+"\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
