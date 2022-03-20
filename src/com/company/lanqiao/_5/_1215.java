package com.company.lanqiao._5;

import java.io.*;
import java.util.Arrays;

/**
 * Author:xie-super
 * Time:2022/3/18
 * Name:1215. 小朋友排队
 * 贪心、树状数组
 */
public class _1215 {
    static final int N = 1000010;
    static int[] tr = new int[N];
    static int[] h = new int[N];
    //存储每个小朋友需要交换的次数
    static int[] sum = new int[N];
    static int n;

    static int lowbit(int x){
        return x & -x;
    }
    static int query(int x){
        int res = 0;
        for(int i = x; i>0; i-=lowbit(i)){
            res += tr[i];
        }
        return res;
    }
    static void add(int x, int v){
        for(int i = x; i<N; i+=lowbit(i)){
            tr[i]+=v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp;

        n = Integer.parseInt(reader.readLine());
        sp = reader.readLine().split(" ");
        for(int i = 1; i<=n; i++){
            h[i] =  Integer.parseInt(sp[i-1]);
            h[i]++;
        }

        //看前面有多少身高高于i的
        for(int i = 1; i<=n; i++){
            sum[i]=  query(N-1)-query(h[i]);
            add(h[i], 1);//此身高的人数+1
        }


        Arrays.fill(tr,0);
        //看后面有多少身高低于i的
        for(int i = n; i>=1; i--){
            sum[i]+=query(h[i]-1);
            add(h[i], 1);
        }

        long res = 0;
        for(int i = 1; i<=n; i++){
            res+= (long) (1 + sum[i]) *sum[i]/2;
        }
        writer.write(res+"");
        writer.flush();
        writer.close();
        reader.close();


    }
}
