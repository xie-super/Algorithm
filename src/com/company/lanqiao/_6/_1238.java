package com.company.lanqiao._6;

import javafx.beans.property.ReadOnlyIntegerWrapper;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:xie-super
 * Time:2022/3/25
 * Name:1238. 日志统计
 * Method:双指针
 */

public class _1238 {
    static class Log implements Comparable<Log>{
        public int x;
        public int y;
        Log(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Log o) {
            return this.x - o.x;
        }
    }
    private static final int N = 100010;
    static int n, d, k;
    static boolean[] isUsed = new boolean[N];

    static int[] cnt = new int[N];
    static Log[] logs = new Log[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp;
        sp = reader.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        d = Integer.parseInt(sp[1]);
        k = Integer.parseInt(sp[2]);
        for(int i  = 0; i<n; i++){
            sp = reader.readLine().split(" ");
            logs[i] = new Log(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]));

        }
        Arrays.sort(logs, 0, n);
        for(int i = 0, j=0; i<n ;i++){
            cnt[logs[i].y]++;
            while(logs[i].x-logs[j].x>=d){
                cnt[logs[j].y]--;
                j++;
            }
            if(cnt[logs[i].y]>=k){
                isUsed[logs[i].y] = true;
            }

        }

        for(int i = 0; i<N; i++){
            if(isUsed[i]){
                writer.write(i+"");
                writer.write("\n");
            }
        }

        writer.flush();
        writer.close();
        reader.close();

    }



}
