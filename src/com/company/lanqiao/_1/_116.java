package com.company.lanqiao._1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:xie-super
 * Time:2022/2/27
 * Name: AcWing 116. 飞行员兄弟,4*4矩阵，每个位置最多状态改变一次，4*4 = 16， 暴力枚举2^16情况
 */
public class _116 {

    private static final int N = 5;
    static char g[][] = new char[N][N];
    static char backup[][] = new char[N][N];
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static List list = new ArrayList();

    public static int getXY(int x, int y){
        return x*4+y;
    }
    public static void turnAll(int x, int y){
        for(int i = 0; i<4; i++){
            turnOne(x,i);
            turnOne(i,y);
        }
        turnOne(x, y);//x,y状态变了两次

    }
    public static void turnOne(int x, int y){
        if(g[x][y] == '-'){
            g[x][y] = '+';
        }else {
            g[x][y] = '-';
        }
    }
    public static void main(String[] args) throws IOException {
        for(int i = 0; i<4; i++){
                String s = reader.readLine();
                g[i] = s.toCharArray();
        }

        for(int o = 0; o<(1<<16); o++){
            //备份
            for(int i = 0; i<4; i++){backup[i] = Arrays.copyOf(g[i], 4);}

            List tempList = new ArrayList();
            for(int x = 0; x<4; x++){
                for(int y = 0; y<4;y++){
                    if((o>>getXY(x,y)&1)==1){
                        //此处状态需要改变，存储横纵坐标，然后操作
                        int xy[] = new int[]{x,y};

                        tempList.add(xy);
                        turnAll(x, y);

                    }
                }
            }
            boolean flag = false;
            for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    if (g[i][j] == '+') {
                        flag = true;
                    }
                }
            }
            if (flag == false){
                if(list.isEmpty()||list.size()>tempList.size()) list = tempList;


            }
            for(int i = 0; i<4; i++) {g[i] = Arrays.copyOf(backup[i], 4);}
        }

        writer.write(list.size()+"\n");
        for(int i = 0; i<list.size();i++){
            int[] xy = (int [])list.get(i);
            xy[0]++;
            xy[1]++;
           writer.write(xy[0]+" "+xy[1]+"\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
