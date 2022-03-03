package com.company.lanqiao._3;

import java.util.*;
/**
 * Author:xie-super
 * Time:2022/3/3
 * Name:AcWing 1205. 买不到的数目
 * method: 两个互斥的数a,b，其组合后最大不能得到的数为(a-1)*(b-1)-1
 */
/*

 */
public class _1205 {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();

        int result = (n-1)*(m-1)-1;
        System.out.println(result);

    }
}
