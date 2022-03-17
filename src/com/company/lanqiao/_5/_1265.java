package com.company.lanqiao._5;

import java.io.*;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/11
 * Name:1265. 数星星,
 * Method:树状数组， 因为星星的增加顺讯为递增的，最后放置的星星肯定是x值最大只需要找出<=此x值的数量即可，因此可用树状数组
 */
public class _1265 {
    private static final int N = 32010;
    static int[] sum = new int[N];
    static int[] tr = new int[N];
    static int n;
    static int x,y;
    public static int lowbit(int x){
        return x & -x;
    }
    static void add(int x){
        for(int i = x; i<=32010; i+=lowbit(i)){
            tr[i]+=1;
        }
        //前面符合的数量
        int res = query(x) ;
        sum[res]++;

    }
    static int query(int x){
        int res = 0;
        for(int i =x; i>0; i-=lowbit(i)){
            res += tr[i];
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        String[] sp ;
        for(int i = 0; i<n; i++){
            sp = reader.readLine().split(" ");
            x = Integer.parseInt(sp[0]);
            //预防x = 0的情况，0& -0
            x++;
            add(x);

        }
        for(int i = 1; i<=n; i++){
            writer.write(sum[i]+"\n");
        }

        writer.flush();
        writer.close();
        reader.close();

    }
}
