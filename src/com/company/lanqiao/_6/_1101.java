package com.company.lanqiao._6;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import javafx.util.Pair;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:xie-super
 * Time:2022/3/25
 * Name:1101. 献给阿尔吉侬的花束
 * Method:bfs
 */
public class _1101 {
    private static final int N = 210;
    static char[][] g = new char[N][N];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] dist = new int[N][N];
    static int t;
    static int r, c;
    static class Pair{
       public int x;
       public int y;
       Pair(int x, int y){
           this.x = x;
           this.y = y;
       }

        public Pair() {

        }
    }

    static int bfs(Pair start, Pair end){
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<r; i++){
            Arrays.fill(dist[i], -1);
        }
        dist[start.x][start.y] = 0;//开始位置
        q.add(start);
        while (!q.isEmpty()){
            Pair p = q.poll();

            for(int i = 0; i<4; i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(x < 0 || x >= r || y < 0 || y >= c) continue; //出界
                if(g[x][y] == '#'){
                    continue;
                }
                if(dist[x][y]!=-1){//已经走过
                    continue;
                }
                dist[x][y] = dist[p.x][p.y]+1;
                if(x == end.x && y == end.y){
                    return dist[x][y];
                }
                q.add(new Pair(x,y));
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(reader.readLine());

        String[] sp;
        String line;
        Pair start = new Pair();
        Pair end =new Pair();

        for(int i = 0; i<t; i++){
            sp = reader.readLine().split(" ");
            r = Integer.parseInt(sp[0]);
            c = Integer.parseInt(sp[1]);
            for(int x = 0; x<r; x++){
                line = reader.readLine();
                g[x] = line.toCharArray();

            }
            for(int x = 0; x<r; x++){
                for(int y = 0; y<c; y++){
                    if(g[x][y] == 'S'){
                        start.x = x;
                        start.y = y;
                    }
                    if(g[x][y] == 'E'){
                        end.x = x;
                        end.y = y;
                    }
                }
            }
            int dis = bfs(start, end);
            if(dis == -1){
                writer.write("oop!"+"\n");

            }else {
                writer.write(dis+"\n");

            }
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
