package com.company.lanqiao._1;

import java.io.*;

/**
 * Author:xie-super
 * Time:2022/2/27
 * Name:1208. 翻硬币
 * Method:前后两种状态中硬币朝向不同的位置肯定需要翻转
 * **********
 * o****o****，如这种情况下第一个硬币需要反转，前面两个硬币情况变化为oo第二个硬币与最终状态相反，那么其需要翻转，两种选择，左或者you，因为左已经
 * 翻转过一次，故需要与右边硬币同时翻转，因此结论为从头开始翻转，n个硬币有n-1种变化情况，且每种情况至多用一次,且最终复原后其中途情况有且仅有一种
 */
public class _1208 {
    private static final int N =101;
    static char[] p = new char[N];
    static char[] e = new char[N];
    static int length;
    static int step;
    static boolean isUsed[] = new boolean[N];//0表示没有翻转过，1表示翻转过

    static void turn(int u){
        if(p[u]=='*'){
            p[u]='o';
        }else {
            p[u] = '*';
        }
        if(p[u+1]=='*'){
            p[u+1]='o';
        }else {
            p[u+1] = '*';
        }
    }
    public static void dfs(int u){
        if(u==length-1){
            return;
        }
        if (p[u] != e[u]) {
            step++;

            turn(u);
        }
        dfs(u+1);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = reader.readLine();
        p = s1.toCharArray();

        s1 = reader.readLine();
        e = s1.toCharArray();
        step = 0;
        length = e.length;

        dfs(0);

        System.out.println(step);







        reader.close();
        writer.flush();
        writer.close();


    }
}
