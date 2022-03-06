package com.company.lanqiao._3;

import java.util.*;
import java.io.*;
public class Main{
    private static final int N = 6;
    static char g[][] = new char[N][N];
    static char backup[][] = new char[N][N];
    static int dx[] = new int[]{-1, 0, 1, 0, 0};
    static int dy[] = new int[]{0, -1, 0, 1, 0};
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;


    public static void turn(int x, int y){
        for(int i = 0; i<5; i++){
            //周围横纵坐标
            int a = x+dx[i], b = y+dy[i];
            if(a<0||b<0||a>4||b>4) continue;
            g[a][b]^=1;//变更状态
        }
    }
    public static void main (String[] args)throws IOException{
        String sp;
        n = Integer.parseInt(reader.readLine());

        for(int i = 0; i<n;i++){

            int result = 7;
            for(int x = 0; x<5; x++){
                sp = reader.readLine();
                g[x] = sp.toCharArray();
            }

            for(int o=0; o<32; o++){
                int step = 0;
                for(int x =0; x<5; x++){
                    backup[x] = Arrays.copyOf(g[x],5);

                }
                for(int x = 0; x<5; x++){
                    if((o>>x&1)==1){//1表示状态改变
                        step++;
                        turn(0, x);
                    }
                }
                for(int x = 0; x<4; x++){
                    for(int y =0; y<5; y++){
                        if(g[x][y]=='0'){
                            step++;
                            turn(x+1,y);
                        }
                    }
                }

                boolean flag = false;
                for(int x = 0; x<5;x++){
                    if(g[4][x] == '0'){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    result = Math.min(result, step);
                }



                for(int x =0; x<5; x++){
                    g[x] = Arrays.copyOf(backup[x],5);

                }

            }
            if(result>6){
                result =-1;

            }
            writer.write(result+" ");
            writer.write("\n");
            if(i!=n-1){
                String s2 = reader.readLine();}
        }


        reader.close();
        writer.flush();
        writer.close();
    }
}
