package com.company.lanqiao._1;

import java.io.*;

/**
 * Author:xie-super
 * Time:2022/2/26
 * Name:93. 递归实现组合型枚举
 */
public class _93 {

    public static int n, m;
    private static final int N =26;
    public static int array[] = new int[N];
    public static boolean isUsed[] = new boolean[N];//0表示没用过
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int u) throws IOException {
        if(u>m){

            for(int i = 1; i<=m; i++){
                writer.write(array[i]+" ");
            }
            writer.write("\n");
            return;
        }
        //必须由大到小，且每层数的特点为小于等于n-m+u,比如说输入5 3 ，第一个数小于等于3
        for(int i = array[u-1]; i<=n-m+u;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                array[u] = i;
                dfs(u+1);
                array[u] = 0;
                isUsed[i] = false;

            }
        }
    }

    public static void main(String[] args) throws IOException {

        isUsed[0] = true;
        String[] s1 = reader.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);

        dfs(1);

        reader.close();
        writer.flush();
        writer.close();
    }
}
