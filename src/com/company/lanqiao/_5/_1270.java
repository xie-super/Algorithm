package com.company.lanqiao._5;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.io.*;

/**
 * Author:xie-super
 * Time:2022/3/17
 * Name:数列区间最大值
 */


class TR{
    public int l, r;
    public long max;
    TR(int l, int r, long max){
        this.l = l;
        this.r = r;
        this.max = max;
    }

    TR(int l, int r){
        this.l = l;
        this.r = r;
    }
}
public class _1270 {

    private static final int N   =  100010;
    static long[] a = new long[N];
    static TR[] tr = new TR[N*4];
    static int n, m;
    static int INF_MIN=-2147483648;
    static void push_up(int u){
        tr[u].max = Math.max(tr[u<<1].max, tr[u<<1|1].max);

    }
    static void build(int u, int l, int r){
        if(l == r){
            tr[u] = new TR(l, r, a[r]);
        }else {
            tr[u] = new TR(l, r);
            int mid = l +r >>1;
            build(u<<1, l, mid);
            build(u<<1 |1, mid+1, r);
            push_up(u);
        }
    }
    static long  query(int u, int l, int r){
        if(l<=tr[u].l && r>=tr[u].r){
            return tr[u].max;
        }
        int mid = tr[u].l +tr[u].r>>1;
        long res = -INF_MIN;
        if(mid>=l){
            res =  query(u<<1, l, r);
        }
        if(r>=mid+1){
            res =  Math.max(query(u<<1 |1, l, r),res);

        }
        return res;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]sp;
        sp = reader.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        sp =reader.readLine().split(" ");
        for(int i = 1; i<=n; i++){
            a[i] = Integer.parseInt(sp[i-1]);
        }

        build(1, 1, n);

        for(int i = 0; i<m ;i++){
            sp = reader.readLine().split(" ");

            int l,r;
            l = Integer.parseInt(sp[0]);
            r = Integer.parseInt(sp[1]);
            long res = query(1, l, r);
            writer.write(res+"\n");

        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
