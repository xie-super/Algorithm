package com.company.lanqiao._5;

import java.io.*;
import java.nio.Buffer;

/**
 * Author:xie-super
 * Time:2022/3/20
 * Name:IntelliJ IDEA
 */
public class _1232 {
    private static int N = 110;
    static int[][][] a = new int[N][N][N];
    static int A,B,C,m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp;
        sp = reader.readLine().split(" ");
        A = Integer.parseInt(sp[0]);
        B = Integer.parseInt(sp[1]);
        C = Integer.parseInt(sp[2]);
        m = Integer.parseInt(sp[3]);
        int index = 0;
        sp = reader.readLine().split(" ");
        for(int i = 1; i<=A; i++){
            for(int j = 1; j<=B; j++){
                for(int k = 1; k<=C; k++){
                    a[i][j][k] = Integer.parseInt(sp[index++]);
                }
            }
        }

        int x1, x2, y1, y2, z1, z2, v;
        int res = 0;
        for(int x  =0 ; x<m; x++){
            res++;
            sp = reader.readLine().split(" ");
            x1 = Integer.parseInt(sp[0]);
            x2 = Integer.parseInt(sp[1]);
            y1 = Integer.parseInt(sp[2]);
            y2 = Integer.parseInt(sp[3]);
            z1 = Integer.parseInt(sp[4]);
            z2 = Integer.parseInt(sp[5]);
            v = Integer.parseInt(sp[6]);
            for(int i = x1; i<=x2; i++){
                for(int j = y1; j<=y2; j++){
                    for(int k = z1; k<=z2;k++){
                        a[i][j][k] -= v;
                        if(a[i][j][k]<0){
                            writer.write(res+"");
                            writer.flush();
                            writer.close();
                            reader.close();
                            return;
                        }
                    }
                }
            }
        }

    }

}
