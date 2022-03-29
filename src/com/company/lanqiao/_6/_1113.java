package com.company.lanqiao._6;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:xie-super
 * Time:2022/3/26
 * Name:1113. 红与黑
 * Method:Flood Fill
 */
/*BFS 法
public class _1113 {
    private static final int N =25;
    static char[][] g = new char[N][N];
    static int w, h;
    static class Pair{
        public int x;
        public int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int a, int b){
        int res = 0;
        Queue<Pair> q = new LinkedList<>();
        g[a][b] = '#';
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        q.add(new Pair(a,b));
        while(!q.isEmpty()){
            Pair t = q.poll();
            res++;
            for(int i = 0; i<4; i++){
                int x = t.x+dx[i];
                int y = t.y+dy[i];
                if(x<0 || x>=h || y<0 || y>=w || g[x][y] !='.'){
                    continue;
                }
                g[x][y]= '#';
                q.add(new Pair(x, y));
            }
        }
        return res;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp;
        String line;
        boolean flag = true;
        while (flag == true){
            sp = reader.readLine().split(" ");
            w = Integer.parseInt(sp[0]);
            h = Integer.parseInt(sp[1]);

            if(w==0 && h == 0){
                flag = false;
                continue;
            }
            for(int i = 0; i<h; i++){
                line = reader.readLine();

                g[i] = line.toCharArray();
            }
            int x = 0,y = 0;
            for(int i = 0; i<h; i++){
                for(int j= 0;j<w; j++){
                    if(g[i][j]=='@'){
                        x = i;
                        y = j;
                    }
                }
            }
            int res = bfs(x, y);
            writer.write(res+"\n");

        }

        writer.flush();
        writer.close();
        reader.close();

    }
}


 */

//DFS
public class _1113 {
    private static final int N = 25;
    static boolean[][] st = new boolean[N][N];
    static char[][] g = new char[N][N];
    static int h, w;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int dfs(int x, int y){
        g[x][y] = '#';
        int cnt = 1;
        for(int i = 0; i<4; i++){
            int a = x+dx[i];
            int b = y + dy[i];
            if(a<0 || a>=h || b<0 || b>=w || g[a][b]!='.'){
                continue;
            }
            cnt+=dfs(a, b);
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp;
        String line;
        boolean flag = true;
        while (flag == true){
            sp = reader.readLine().split(" ");
            w = Integer.parseInt(sp[0]);
            h = Integer.parseInt(sp[1]);
            if(w==0 && h == 0){
                flag = false;
                continue;
            }
            for(int i = 0; i<h; i++){
                line = reader.readLine();
                g[i] = line.toCharArray();
            }
            int x = 0, y = 0;
            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(g[i][j] == '@'){
                        x = i;
                        y = j;
                    }
                }
            }
            writer.write(dfs(x, y)+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();

    }
}