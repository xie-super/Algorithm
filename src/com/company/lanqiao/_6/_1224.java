package com.company.lanqiao._6;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/25
 * Name:1224. 交换瓶子
 * Method:图论
 */
public class _1224 {
    private static int N  = 10010;
    static boolean[] sta = new boolean[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in);
        int n = input.nextInt();
        for(int i = 1; i<=n ;i++){
            b[i] = input.nextInt();

        }
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            if(!sta[i]){
                cnt++;
                for(int j = i; !sta[j]; j = b[j]){
                    sta[j] = true;
                }
            }
        }
        System.out.println(n-cnt);
    }
}
