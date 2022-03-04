package com.company.lanqiao._3;
import java.util.*;
/**
 * Author:xie-super
 * Time:2022/3/3
 * Name:1216. 饮料换购
 * Method: 数论
 */
public class _1216 {

    static int n;

    //瓶子与瓶盖的数量
    static  int bottle,cap;
    public static void dfs(int n){
        if(n<3){
            return;
        }
        int exchangeBottle = n/3;//换来的啤酒数量
        bottle+=exchangeBottle;
        int restCap = exchangeBottle+(n%3);//剩余瓶盖的数量
        dfs(restCap);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        bottle+=n;
        //剩下的是瓶盖进入dfs
        dfs(n);
        System.out.println(bottle);
    }
}
