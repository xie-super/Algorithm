package com.company.lanqiao._5;

import javafx.util.Builder;

import java.io.*;
import java.nio.Buffer;

/**
 * Author:xie-super
 * Time:2022/3/20
 * Name:798. 差分矩阵
 */
public class _798 {
    private static final int N = 1010;

    static int a[][] = new int[N][N];
    static int b[][] = new int[N][N];

    static int n,m,k;

    static void insert(int x1,int y1, int x2, int y2,int v){
        b[x1][y1]+=v;
        b[x1][y2+1]-=v;
        b[x2+1][y1]-=v;
        b[x2+1][y2+1]+=v;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp;
        sp = reader.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        k = Integer.parseInt(sp[2]);
        for(int i  = 1; i<=n; i++){
            sp = reader.readLine().split(" ");
            for(int j = 1; j<=m; j++){
                a[i][j] = Integer.parseInt(sp[j-1]);
            }
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m ;j++){
                insert(i,j,i,j,a[i][j]);
            }
        }

        int x1, y1, x2, y2,v;
        for(int i = 0;i<k; i++){
            sp = reader.readLine().split(" ");
            x1 = Integer.parseInt(sp[0]);
            y1 = Integer.parseInt(sp[1]);
            x2 = Integer.parseInt(sp[2]);
            y2 = Integer.parseInt(sp[3]);
            v = Integer.parseInt(sp[4]);
            insert(x1, y1, x2, y2, v);
        }

        for(int i  =1; i<=n; i++){
            for(int j=1; j<=m; j++){
                b[i][j] = b[i-1][j]+b[i][j-1]-b[i-1][j-1]+b[i][j];
                writer.write(b[i][j]+" ");
            }
            writer.write("\n");
        }
        writer.flush();
        writer.close();
        reader.close();

    }
}
