package com.company.lanqiao._3;


import java.util.*;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/3
 * Name: 1211. 蚂蚁感冒
 * Method:
 */
public class _1211 {
    private static final int N  = 50;
   
    static int n;
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Integer[] a = new Integer[n];
        Integer[] cnt = new Integer[N];
        int start = 0;
        for(int i = 0; i<n;i++){
            int num = input.nextInt();
            //0代表正数，1代表负数
            int flag = 0;
            if(num<0){flag = 1;}
            num  =Math.abs(num);
            if(i == 0){
                start = num;
            }
            a[i] = num;
            cnt[num] = flag;

        }

        Arrays.sort(a, 0, a.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }


        });
        //计算感染的数量，以第一个感染的蚂蚁为中心， 其感染的蚂蚁数量为其朝向一侧感染的数量为与其朝向相反的蚂蚁数量，其背对一项为与其朝向相同蚂蚁数量
        //开始感染蚂蚁向右走时计数
        int count = 0;



            //初始朝向为右
            int i  =0;
            boolean flag = false;//特判用
            for(; i<n; i++){
                if(a[i]!=start){//从最左边到感染蚂蚁
                    if(cnt[a[i]]==0){//左侧向右的蚂蚁
                        count++;
                        flag = true;//存在想右边的蚂蚁
                    }else {
                        continue;
                    }
                }else {//感染蚂蚁右侧
                    //特判一下，若感染蚂蚁一边的蚂蚁朝向与感染蚂蚁的朝向都相同，那么就不会二次感染
                    if(cnt[start] == 1){//感染蚂蚁开始朝向左边
                        if(!flag){
                            System.out.println(1);
                            return;
                        }
                    }
                    flag = false;
                    for(i = i+1; i<n; i++){
                        if(cnt[a[i]]==1) {//右侧向左的蚂蚁
                            count++;
                            flag = true;//存在向左走的蚂蚁
                        }else {
                            continue;
                        }
                    }
                    if(cnt[start]==0){
                        if(!flag){//感染蚂蚁右侧全往右走
                            System.out.println(1);
                            return;
                        }
                    }
                }

            }
            //算上本身
             count++;
             System.out.println(count);




    }
}