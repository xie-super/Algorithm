package com.company.lanqiao._2;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/2
 * Name:730. 机器人跳跃问题
 *Method:二分
 */
public class _730 {
    private static final int N = 100010;
    static int [] array = new int[N];
    static int n;

    static boolean check(int num){
        for(int i  = 0 ;i<n; i++){
            if((2*num - array[i])>=0){
                num = 2*num - array[i];
                //越界问题，当num足够大时会成为负数
                if(num >=1e5) return true;
            }else {
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for(int i = 0; i<n;i++){
            array[i] = input.nextInt();
        }

        int l  =0, r = 100000;
        while(l<r){
            int mid  = l + (r-l+1>>1);

            if(check(mid)){
                System.out.println(l+" "+mid);
                r  = mid;
            }else {
                l = mid+1;
            }
        }
        System.out.println(r);

    }
}
