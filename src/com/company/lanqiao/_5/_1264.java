package com.company.lanqiao._5;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import javax.swing.*;
import java.io.*;

/**
 * Author:xie-super
 * Time:2022/3/10
 * Name:1264. 动态求连续区间和
 * Method：树状数组、线段树
 */
/*树状数组
public class _1264 {
    private static final int N = 100010;
    static int[] a = new int[N];
    static int[] tr = new int[N];
    static int n, m;
    static int k, l,r;
    static int lowbit(int x){
        return x & -x;
    }
    static void add(int x, int v){
        for(int i = x; i<=n; i+=lowbit(i)){
            tr[i]+=v;
        }
    }
    static int query(int x){
        int res = 0;
        for(int i = x; i>0; i-=lowbit(i)){
            res+=tr[i];
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp;
        sp = reader.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);

        sp =reader.readLine().split(" ");

        for(int i = 1; i<=n; i++){
            a[i] = Integer.parseInt(sp[i-1]);
        }

        for(int i = 1; i<=n; i++){
            add(i, a[i]);
        }

        for(int i = 0; i<m; i++){
            sp = reader.readLine().split(" ");
            k = Integer.parseInt(sp[0]);
            l = Integer.parseInt(sp[1]);
            r = Integer.parseInt(sp[2]);

            if(k == 0){
                int res = query(r) - query(l-1);
                writer.write(res+"\n");
            }else {
                add(l,r);
            }
        }


    writer.flush();
    writer.close();
    reader.close();

    }

}

 */

//线段树  https://www.acwing.com/solution/content/40394/
class TR{
    public int l;
    public int r;
    public int sum;

     public TR(int l, int r, int sum){
        this.l = l;
        this.r = r;
        this.sum = sum;
    }
    public TR(int l, int r){
         this.l = l;
         this.r = r;
    }



    public int getL() {
        return l;
    }
    public void setL(int l){
        this.l = l;
    }
    public int getR() {
        return r;
    }
    public void setR(int r){
        this.r =  r;
    }
    public int getSum(){
        return sum;
    }
    public void setSum(int sum){
        this.sum = sum;
    }

}

public class _1264{
    private static final int N = 100010;
    static int[] a = new int[N];
    static TR[] tr = new TR[4*N];
    static int n, m;
    static int k, l,r;

    static void push_up(int u){
        tr[u].sum = tr[u<<1].sum+tr[u<<1|1].sum;
    }
    static void build(int u, int l, int r){
        if(l == r){
            tr[u] = new TR(l,r,a[r]);
        }else {
            tr[u] = new TR(l,r);
            int mid = l+r>>1;
            build(u<<1, l, mid);
            build(u<<1|1, mid+1,r);
            push_up(u);
        }
    }

    static int query(int u, int l, int r){
        if(l<=tr[u].l && r>=tr[u].r){
            return tr[u].sum;
        }
        int sum = 0;

        int mid = tr[u].l + tr[u].r >> 1;

        if(mid >= l){
            sum+= query(u<<1, l, r);
        }
        if(r>=mid+1){
            sum+=query(u<<1|1, l, r);
        }

        return sum;
    }

    static void modify(int u, int x, int v){
        if(tr[u].l == tr[u].r){
            tr[u].sum+=v;
            return ;
        }
        int mid  = tr[u].l + tr[u].r >>1;
        if(x<=mid){
            modify(u<<1, x, v);
        }else {
            modify(u<<1 | 1, x, v);

        }

        push_up(u);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp;
        sp = reader.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);

        sp =reader.readLine().split(" ");

        for(int i = 1; i<=n; i++){
            a[i] = Integer.parseInt(sp[i-1]);
        }

        build(1,1,n);//建造区间，三参数：根结点编号， 建造区间


        for(int i = 0; i<m; i++){
            sp = reader.readLine().split(" ");
            k = Integer.parseInt(sp[0]);
            l = Integer.parseInt(sp[1]);
            r = Integer.parseInt(sp[2]);

            if(k == 0){
                int res = query( 1,  l,  r);
                writer.write(res+"\n");
            }else {
                modify(1, l,r);
            }
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}