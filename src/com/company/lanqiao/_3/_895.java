package com.company.lanqiao._3;

import java.util.*;

/**
 * Author:xie-super
 * Time:2022/3/4
 * Name:895. 最长上升子序列
 * Method:最长子序列， 线性DP， 状态表示为f[i]为以i结尾的最长子序列
 */


public class _895
{

    static int n;
    private static final int N =1010;
    static int[] a = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        n = input.nextInt();
        for(int i =1; i<=n; i++){
            a[i] = input.nextInt();
        }
        for(int i = 1; i<=n; i++){
            f[i] = 1;
            //状态运算为将将i之前的状态划分集合，组成f[i]的最长子序列的倒数第二个数a[j]
            for(int j = 1; j<i; j++){
                if(a[i]>a[j]){
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
        }
        int res = 0;
        for(int i = 1; i<=n; i++){
            res = Math.max(res, f[i]);
        }
        System.out.println(res);

    }

}