package com.company.lanqiao._1;

import java.util.Scanner;
/*
author:xie-super
Name:AcWing 92. 递归实现指数型枚举
 */
public class _92 {

    //全局变量
    //记录状态的数组，0代表还未考虑，1未选中，2选中
    public static final int N = 16;
    public static int[] state = new int[N];

    public static void dfs(int u,int n){
        if(u == n+1){
            for(int i = 1; i<=n;i++){
                if(state[i]==2){
                    System.out.print(i);
                    System.out.print(" ");

                }
            }
            System.out.println();
            return;
        }
        //二叉树分情况递归
        //左右选中与不选中
        state[u] = 1;
        dfs(u+1, n);
        //恢复
        state[u] = 0;

        state[u] = 2;
        dfs(u+1, n);
        state[u] = 0;

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        //深度递归
        dfs(1, number);


    }
}
