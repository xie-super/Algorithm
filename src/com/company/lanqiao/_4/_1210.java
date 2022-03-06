package com.company.lanqiao._4;

/**
 * Author:xie-super
 * Time:2022/3/5
 * Name:1210. 连号区间数
 * Method :枚举
 */

import java.util.*;
public class _1210{
    //1-N的某个排列中，其规律为没有重复元素，利用此性质判断某个区间是不是连续的区间，
    //比如1，3，2。中最大值为3， 最小值为1， 其差值即为最大索引于最小的索引的差值。
    private static final int INF = 100000;
    private static final int N = 10010;
    static int[] a = new int[N];
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        int n = input.nextInt();

        for(int i = 0; i<n; i++){
            a[i] = input.nextInt();

        }
        int res = 0;
        for(int i = 0; i<n ;i++){
            int max = a[i], min = a[i];
            for(int j = i; j<n;j++){
                max = Math.max(a[j],max);
                min = Math.min(a[j],min);
                if((max-min) == j-i){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

