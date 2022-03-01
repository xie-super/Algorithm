package com.company.lanqiao._2;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/1
 * Name:796. 子矩阵的和
 */
public class _796 {
    private static final int N = 10010;
    static int[][] a = new int[N][N];
    static int[][] sum = new int[N][N];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n =input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                a[i][j] = input.nextInt();
                sum[i][j] = sum[i][j-1]+sum[i-1][j] -sum[i-1][j-1] +a[i][j];

            }
        }
        for(int i = 0; i<q; i++){
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            a[0][i] = sum[x2][y2] - sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];

        }
        for(int i = 0; i<q; i++){
            System.out.println(a[0][i]);
        }

    }
}
