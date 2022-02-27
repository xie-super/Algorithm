package com.company.lanqiao._1;

import java.io.*;

/**
 * Author:xie-super
 * Time:2022/2/26
 * Name:717. 简单斐波那契 0, 1, 1, 2, 3, 5, 8.....
 */
public class _717 {
    private static final int N = 46;
    static int array[] = new int[N];//存储斐波那契数列

    public static void toArray(int n){
        array[0] = 0;
        array[1] = 1;
        if(n<=2){
            return;
        }
        for(int i = 3; i<=n; i++){
            array[i-1] = array[i-2]+array[i-3];
        }
    }

    public static void main(String[]  args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = bufferedReader.readLine();
        int n = Integer.parseInt(s1);

        toArray(n);

        for(int i = 0; i<n; i++){
            bufferedWriter.write(array[i]+" ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();


    }

}
