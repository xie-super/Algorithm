package com.company.lanqiao._5;

import java.io.*;
import java.nio.Buffer;

/**
 * Author:xie-super
 * Time:2022/3/20
 * Name:797. 差分
 */
public class _797 {
    private static final int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];//查分数组
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp;

        sp = reader.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        sp = reader.readLine().split(" ");

        for(int i = 1; i<=n;i++){
            a[i] = Integer.parseInt(sp[i-1]);
            b[i] = a[i] - a[i-1];

        }
        int l, r, v;
        for(int i = 0; i<m; i++){
            sp = reader.readLine().split(" ");
            l = Integer.parseInt(sp[0]);
            r = Integer.parseInt(sp[1]);
            v = Integer.parseInt(sp[2]);
            b[l]+=v;
            b[r+1]-=v;

        }
        for(int i = 1; i<=n; i++){
            a[i]=a[i-1]+b[i];
            writer.write(a[i]+" ");
        }
        reader.close();
        writer.flush();
        writer.close();



    }
}
