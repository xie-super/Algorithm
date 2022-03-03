package com.company.lanqiao._2;



import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/2
 * Name:99. 激光炸弹
 * Method:矩阵前缀合
 */
public class _99 {

    private static final int N = 5010;
    static int array[][] = new int[N][N];
    static int sum[][] = new int[N][N];
    static int maxX, maxY;
    //flag分别代表2种情况，0：代表R大于爆炸区域长，小于宽，1代表大于宽ü，小于长，
    public static int
    getSingleValue(int s, int e, int flag){
        if(flag == 0){
            int value = sum[maxX][e] - sum[maxX][s-1];
            //去除左右两边之一
            int oneValue = 0;
            int twoValue = 0;
            for(int i = 1 ;i<=maxX; i++){oneValue+=array[i][s];}
            for(int i = 1 ;i<=maxX; i++){oneValue+=array[i][e];}
            return value-Math.min(oneValue, twoValue);

        }else {
            int value = sum[e][maxY] - sum[s-1][maxY];
            //去除左右两边之一
            int oneValue = 0;
            int twoValue = 0;
            for(int i = 1 ;i<=maxY; i++){oneValue+=array[s][i];}
            for(int i = 1 ;i<=maxY; i++){oneValue+=array[e][i];}
            return value-Math.min(oneValue, twoValue);
        }
    }
    public static int getValue(int x1, int y1, int x2, int y2){


        //整个包围圈的价值
        int value = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1]+sum[x1-1][y1-1];
        //依次分别去除两条相连边，以为激光炸弹只能覆盖边内的区域，故可能去除'口'中左上，左下，下右，上右两条边，三顶点
        //上左下右价值
        int uValue = 0,lValue=0,dValue=0,rValue=0;
        for(int i = y1+1;i<y2;i++){uValue+=array[x1][i];}
        for(int i  = y1+1; i<y2; i++){dValue+=array[x2][i];}
        for(int i = x1+1; i<x2; i++){lValue+=array[i][y1];}
        for(int i = x1+1; i<x2; i++){rValue+=array[i][y2];}
        //左上价值,加上三个顶点
        int one = lValue+uValue+array[x1][y1]+array[x2][y1]+array[x1][y2];
        //左下价值
        int two = lValue+dValue+array[x2][y1]+array[x1][y1]+array[x2][y2];
        //下右价值
        int three = dValue+rValue+array[x2][y2]+array[x2][y1]+array[x1][y2];
        //上右价值
        int four = uValue+rValue+array[x1][y2]+array[x1][y1]+array[x2][y2];
        //然后求出价值最小的
        int minValue = Math.min(one,two);
        minValue = Math.min(minValue, three);
        minValue = Math.min(minValue, four);
        int result = value -minValue;
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp;
        sp = reader.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int r = Integer.parseInt(sp[1]);
        maxX = 0;
        maxY = 0;

        for(int i = 0; i<n;i++){
            //边界从1开始
            sp = reader.readLine().split(" ");

            int x = Integer.parseInt(sp[0])+1;
            maxX = Math.max(x, maxX);
            int y = Integer.parseInt(sp[1])+1;
            maxY = Math.max(maxY, y);
            array[x][y] += Integer.parseInt(sp[2]);

        }

        maxX = Math.min(5001 , r+maxX);
        maxY = Math.min(5001, r+maxY);
        for(int x = 1; x<=maxX;x++){
            for(int y = 1;y<=maxY;y++){
                sum[x][y] = sum[x][y-1]+sum[x-1][y] - sum[x-1][y-1]+array[x][y];

            }
        }
        int result = 0;
        //全包围
        if(r>Math.max(maxX, maxY)-1){
            result = sum[maxX][maxY];

        }else {
            //被全包围
//            for(int x = 1; x+r<=maxX; x++){
//                for(int y =1; y+r<=maxY; y++){
//                    result = Math.max(getValue(x, y, x+r, y+r),result);
//                }
//            }
            for(int x =r; x<=maxX; x++){
                for(int y = r; y<=maxY;y++){
                    result = Math.max((sum[x][y] - sum[x - r][y] - sum[x][y - r] + sum[x - r][y - r]),result);
                }
            }
        }
        System.out.println(result);

        writer.flush();
        writer.close();
        reader.close();

    }
}
