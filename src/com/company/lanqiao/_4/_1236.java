package com.company.lanqiao._4;




import java.io.*;

import java.util.*;

import java.util.Comparator;

/**
 * Author:xie-super
 * Time:2022/3/6
 * Name:1236. 递增三元组
 * Method :枚举，Ai<Bj<Ck,B独立，从B开始枚举, 条件B中第i个值， 找出A中小于此值的个数， C中大于此值的个数
 */
public class _1236 {
    private static final int N = 100010;
    static int[] cntA = new int[N];
    static int[] cntB = new int[N];
    static int[] cntC = new int[N];

    static int[] sA = new int[N];
    static int[] sB = new int[N];
    static int[] sC = new int[N];
    static Integer[] a = new Integer[N];
    static Integer[] b = new Integer[N];
    static Integer[] c = new Integer[N];
    static int n;
    static long result;
    public static void methodOne(){
        for(int i = 1; i<N; i++){
            int index = a[i];
            cntA[index]++;  //找出1-N中数组a,c数值的个数
            index = c[i];
            cntC[index]++;
        }//算前i个数的前缀和
        for(int i= 1; i<N; i++ ){
            sA[i] = sA[i-1]+cntA[i];
            sC[i] = sC[i-1]+cntC[i];
        }

        for(int i = 1; i<=n; i++){

            long l = sA[b[i]-1];//a数组中小于b[i]的元素个数

            long s = sC[N-1] - sC[b[i]];
            result+=l*s;

        }



    }



    public static int getPositionA(int num){
        int l = 0, r = N;

        while (l<r){
            int mid =  l+r>>1;
            if(a[mid]>num){
                r = mid;
            }else{
                l = mid+1;
            }

        }
        return r;
    }
    public static int getPositionC(int num){
        int l = 0, r = N;

        while (l<r){
            int mid =  l+r>>1;
            if(c[mid]>num){
                r = mid;
            }else{
                l = mid+1;
            }

        }
        return r;
    }
    public static void methodTwo() {
        Arrays.sort(a, 0, a.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(b, 0, b.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(c, 0, c.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 1; i <= n; i++) {
            int l = getPositionA(b[i]);
            int s = n - getPositionA(b[i]) - 1;
            result += l * s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        String[] sp1, sp2, sp3;
        sp1 = reader.readLine().split(" ");
        sp2 = reader.readLine().split(" ");
        sp3 = reader.readLine().split(" ");
        for(int i = 0; i<n; i++){
            a[i+1] = Integer.parseInt(sp1[i])+1;
            b[i+1] = Integer.parseInt(sp2[i])+1;
            c[i+1] = Integer.parseInt(sp3[i])+1;//避免出现0的情况

        }

        //前缀和做法
        methodOne();
        writer.write(result+"");

        writer.flush();
        writer.close();
        reader.close();


    }


}

