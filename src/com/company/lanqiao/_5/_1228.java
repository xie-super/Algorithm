package com.company.lanqiao._5;

import java.io.*;
import java.util.Arrays;

/**
 * Author:xie-super
 * Time:2022/3/19
 * Name:AcWing 1228. 油漆面积
 * Method:扫描线+线段树
 */
public class _1228 {
    public static int N = 10010;
    static TR[] tr = new TR[N*4];
    static Segment[] seg = new Segment[N*2];
    static int n;
    //线段结构体，包含竖线的x,y1,y2三个位置信息
    //k表示这条线段是一个矩形的开始还是结束
//结构体数组用来存储所有线段，因为还要先对所有线段排序，按x从小到大的顺序来扫描
    static class Segment implements Comparable<Segment> {
        int x, y1, y2;
        int k;
        Segment(int x, int y1, int y2,int k){
            this.x =x;
            this.y1 = y1;
            this.y2 = y2;
            this.k = k;
        }
        @Override
        public int compareTo(Segment seg) {
            return this.x - seg.x;//按横坐标从小到大排序
        }


    }
    //线段树结点存储的是y轴方向区间的被覆盖长度和被覆盖次数
//l,r分别表示当前区间的端点
//cnt表示结点区间被覆盖次数，len表示结点区间内被覆盖的长度
//len是真正关心的，cnt相当于一个标记用来正确求出len
    static class TR{
        int l,r;
        int cnt, len;

        TR(int l,int  r,int  cnt,int  len){
            this.l = l;
            this.r = r;
            this.cnt = cnt;
            this.len = len;
        }
    }
    static void build(int u, int l, int r){
        tr[u] = new TR(l,r,0,0);
        if(l == r){
            return;
        }
        int mid = l+r>>1;
        if(l<=mid){
            build(u<<1, l, mid);

        }
        if(r>=mid+1){
            build(u<<1|1, mid+1, r);
        }
    }
    static void pushup(int u){
        if(tr[u].cnt>0){
            tr[u].len = tr[u].r - tr[u].l+1;

        }else if(tr[u].l == tr[u].r){
            tr[u].len = 0;
        }else{
            tr[u].len = tr[u<<1].len+tr[u<<1|1].len;
        }
    }
    //修改结点中l到r区间的cnt
    static void modify(int u, int l, int r, int k){
        if(tr[u].l>=l && tr[u].r <=r){
            tr[u].cnt+=k;
            pushup(u);
        }else {
            int mid = tr[u].l+tr[u].r>>1;
            if(l<=mid){
                modify(u<<1, l, r, k);
            }
            if(r>=mid+1){
                modify(u<<1|1 ,l, r, k);
            }
            pushup(u);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        int m = 0;
        String[] sp;
        for(int i=0; i<n; i++) {
            sp = reader.readLine().split(" ");

            seg[m++] = new Segment(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[3]), 1);
            seg[m++] = new Segment(Integer.parseInt(sp[2]), Integer.parseInt(sp[1]), Integer.parseInt(sp[3]), -1);
        }
        Arrays.sort(seg, 0, m);

        build(1, 0, 10000);

        int res  = 0;
        //扫描线法，从左到右扫描竖线，每次扫描到一条竖线，都会修改当前线段树的状态
        for(int i = 0; i<m; i++){
            //i = 0 时为第一条进入的线
            if(i>0){
                res+=tr[1].len*(seg[i].x-seg[i-1].x);
            }
            modify(1, seg[i].y1,seg[i].y2-1, seg[i].k);
        }
        writer.write(res+"");


        writer.flush();
        writer.close();
        reader.close();
    }
}

