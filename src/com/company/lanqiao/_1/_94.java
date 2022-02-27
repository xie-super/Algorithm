package com.company.lanqiao._1;

import java.io.*;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/2/26
 * Name:AcWing 94. 递归实现排列型枚举
 * Method：递归搜索树，依次枚举每个位置填什么数如输入3，第一个位置可填写1，2，3，3种情况下分别递归填第二个位置
 */
public class _94 {

    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int N = 16;
    public static int[] hole = new int[N];//0表示此位-置没有填写，1-N表示此位置填写的数
    public static boolean[] isUsed = new boolean[N];//数字有没有用过
    public static int n;


    public static void dfs(int u) throws IOException {
        if(u>n){
            for(int i=1; i<=n; i++){
               bufferedWriter.write(hole[i]+" ");
            }
            bufferedWriter.write("\n");
            return;
        }
        for(int i = 1; i<=n; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                hole[u] = i;
                dfs(u+1);
                hole[u] = 0;
                isUsed[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        n  = Integer.parseInt(s1);

        dfs(1);
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
