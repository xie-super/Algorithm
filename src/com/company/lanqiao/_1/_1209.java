package com.company.lanqiao._1;

import java.io.*;
import java.util.Arrays;

/**
 * Author:xie-super
 * Time:2022/2/26
 * Name:AcWing 1209. 带分数
 * Method:枚举全排列，枚举位数，判断
 */
public class _1209 {

    private static final int N = 10;
    static boolean isUsed[] = new boolean[N];
    static int hole[] = new int[N];
    static int inputNumber;
    static int bitNumber;
    static int count;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    //获取输入的数据有多少位
    public static int  getBitNumber(int n){
        int num = 0;
        while (true){
            n = n/10;
            if(n!=0){
                num++;
                continue;
            }else {
                num++;
                break;
            }
        }
        return num;
    }

    public static boolean check(int a, int c, int b ){

        String s = "";
        //求a
        int i = 1;
        for( i = 1; i<=a; i++){
            s+=hole[i];
        }
        int a1 = Integer.parseInt(s);
        s ="";
        int j ;
        for(j = i;j<=i+c;j++){
            s+=hole[j];
        }
        float c1 = Integer.parseInt(s);
        s ="";
        int k ;

        for(k = j; k<=9; k++){
            s+=hole[k];
        }
        float b1 = Integer.parseInt(s);


        if((a1+b1/c1) == inputNumber){
            return true;
        }
        return false;
        //求c

    }
    static int calc(int l,int r) {
        int res=0;
        for(int i=l;i<=r;i++) {
            res=res*10+hole[i];
        }
        return res;
    }

    public static void dfs(int u){
        //叶子节点
        if(u>9){
           /*
           n = a+b/c;
           a的位数必小于等于n的位数,c的位数<=b的位数
           先求a位数后求c位数
            */
            for (int i = 1; i <=7; i++) {
                for (int j =i+1; j <=8; j++) {
                    //分成三个区间
                    int a=calc(1,i);
                    int b=calc(i+1,j);
                    int c=calc(j+1,9);
                    //判定的话 是对n=a+b/c进行变换得到cn=ac+b
                    if(a*c+b==c*inputNumber) count++;
                }
            }

            return;
        }
        for(int i = 1; i<=9;i++){
            if(!isUsed[i]){
                isUsed[i]  = true;
                hole[u] = i;
                dfs(u+1);
                hole[u] = 0;
                isUsed[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        count = 0;
        String s1 = reader.readLine();
        inputNumber = Integer.parseInt(s1);
        bitNumber = getBitNumber(inputNumber);



        dfs(1);
        writer.write(count+"");
        reader.close();
        writer.flush();
        writer.close();

    }


}
