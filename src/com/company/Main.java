package com.company;

import java.util.*;
public class Main{
    private static int N = 100010;
    static int[] a = new int[N];
    static int n, q, k;
    static int l, r;
    public static int checkLeft(int num){
         l = 0;
         r = n;

        while(l<r){
            int mid = r+l>>1;

            if(a[mid]>=num){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }

    public static int checkRight(int num){
        int l = 0, r = n;
        while(l<r){
            int mid = (r+l+1)/2;
            if(a[mid]<=num){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        return r;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        q = input.nextInt();

        for(int i=0; i<n; i++){
            a[i] = input.nextInt();
        }

        for(int i = 0; i<q; i++){
            int num = input.nextInt();

            int res = checkLeft(num);
            if(a[res] != num){
                System.out.print(res);
                System.out.println("-1 -1");
            }else{
                System.out.println(res+" "+checkRight(num));

            }
        }

    }
}