package com.company.lanqiao._6;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/26
 * Name:1240. 完全二叉树的权值
 */
public class _1240 {
    private static final int N = 100010;
    static int[] a = new int[N];
    static int[] sum = new int[N];
    static int n;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for(int i = 1; i<=n; i++){
            a[i] = input.nextInt();
            sum[i] = sum[i-1]+a[i];
        }

        int max = -0x3f3f3f3f;
        int flag = -1;
        for(int i = 0; i<n; i++){
            int start = (int) Math.pow(2, i);
            int end = (int) Math.pow(2, i+1)-1;
            if(end>n){end = n;}
            int res = sum[end] - sum[start-1];
            if(max<res){
                max = res;
                flag = i+1;
            }
            if(end == n){
                break;
            }

        }

        System.out.println(flag);

    }
}
