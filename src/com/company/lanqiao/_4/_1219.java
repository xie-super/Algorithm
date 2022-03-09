package com.company.lanqiao._4;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/9
 * Name:1219. 移动距离
 */
public class _1219 {

    static int w, m, n;

    public static int getLawer(int u){
        if(u%w == 0){
            return u/w;
        }else {
            return (u/w+1);
        }
    }

    public static int getPosition(int u){
        int lawer = getLawer(u);
        if(lawer%2==0){
            return w-(u%w-1);
        }else {
            if(u%w == 0){
                return w;
            }
            return u%w;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        w = input.nextInt();
        m = input.nextInt();
        n = input.nextInt();

        int startLaw, endLaw;

        int res = Math.abs(getLawer(m)-getLawer(n))+Math.abs(getPosition(m)-getPosition(n));

        System.out.println(res);

    }
}
