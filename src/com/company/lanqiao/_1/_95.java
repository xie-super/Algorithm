package com.company.lanqiao._1;

import java.io.*;
import java.util.Arrays;

/**
 * Author:xie-super
 * Time:2022/2/26
 * Name:AcWing 95. 费解的开关
 *Method:先枚举第一行的状态，共有2^5种情况，第一行枚举完成后第二行的情况就确定了，例如第一行j列为状态为0，第二行j列必需点亮一次，反之则不点亮，点亮的位置顺序对最后的结果
 * 无影响，且每个位置最多点亮一次，最后一行若不能全部点亮，则此次输入不能完成。
 */
public class _95 {
    private static final int N = 6;
    static char g[][] = new char[N][N];
    static char backup[][] = new char[N][N];
    static int dx[] = new int[]{-1, 0, 1, 0, 0};
    static int dy[] = new int[]{0, -1, 0, 1, 0};
    public static void turn(int x, int y){
        for(int i = 0; i<5; i++){
            //周围横纵坐标
            int a = x+dx[i], b = y+dy[i];
            if(a<0||b<0||a>4||b>4) continue;
            g[a][b]^=1;//变更状态
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

       for(int x = 0; x<n;x++){
           //赋值
            for(int i = 0; i<5; i++){
                String s1 = reader.readLine();
                g[i] = s1.toCharArray();

            }
            int res = 7;
            //第一行状态进行枚举，有2^5种情况，_____填坑
           for(int o = 0; o<32; o++){
               //进行备份
               int step = 0;

               for(int i=0;i<5;i++){backup[i] = Arrays.copyOf(g[i],5);}
               for(int i = 0;i<5;i++) {
                   //分32种情况进行讨论，此次目的为枚举出对原来灯的状态怎样改变，0代表第一行种此位置上不改变状态，1表示此位置上改变状态
                   if ((o >> i & 1)==1) {
                       step++;//为1，表示第一行中此位置状态改变
                       turn(0, i);//状态改变函数

                   }
               }
               /*
               此时第一行该如何变化已经确定，然后按照原先策略进行每一行状态的改变，此时最后的结果已经确定，即上一行为0，下一行必须点亮，否则不变

               i为行，j为列
                */
               for(int i = 0; i<4; i++){
                   for(int j = 0;j<5;j++){
                       if(g[i][j] == '0'){
                           step++;
                           turn(i+1,j);
                       }
                   }
               }
               //确定最后一行有没有没有点亮的，若有则结束，没有则与6进行比较

               boolean flag = false;
               for(int i = 0; i<5;i++){
                   if(g[4][i] == '0'){
                       flag = true;
                       break;
                   }
               }
               if(!flag) res = Math.min(res, step);
                //恢复愿状态，继续枚举第一行状态
               for(int i=0;i<5;i++){g[i] = Arrays.copyOf(backup[i],5);}

           }
           if(res>6){res = -1;}
           writer.write(res+"\n");
            if(x!=n-1){
           String s2 = reader.readLine();}
        }



       reader.close();
       writer.flush();
       writer.close();
    }
}
