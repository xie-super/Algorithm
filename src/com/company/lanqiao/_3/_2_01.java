package com.company.lanqiao._3;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/3
 * Name:AcWing 2. 01背包问题
 * Method: DP
 */
public class _2_01 {

    private static final int N =1010;
    public static int[][] f = new int[N][N];
    public static int[] v =new int[N];
    public static int[] w = new int[N];
    //f[i][j]含义为从前i件物品中，背包容量为j时所选物品价值最大

    static int n, m;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        for(int i = 1; i<=n; i++){
            v[i] = input.nextInt();
            w[i] = input.nextInt();
        }

        //f[i][j]不好求，转换为两种状态，即放或不放第i件物品，1.f[i-1][j]即当容量为j从前i-1件物品中挑选物品达到价值最大2.f[i-1][j-v[i]]+w[i],即必挑选第i件物品，前面i-1件物品看着挑
        //计算最大价值
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                f[i][j] = f[i-1][j];
                if(j>=v[i]){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]]+w[i]);
                }
            }
        }
        System.out.println(f[n][m]);

    }

}
