package com.company;

import java.io.*;
import java.util.*;
class Pair{
    public int x;
    public int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;

    }
    Pair(){

    }
}
public class Main{
    private static final int N = 1010;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int n;
    static boolean flag;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int bfs(int a, int b){
        if(st[a][b] == true){
            return 0;
        }
        int res = 0;
        int cnt = 0;
        st[a][b] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));
        while(!q.isEmpty()){
            cnt = 0;
            Pair t = q.poll();
            res++;
            for(int i = 0; i<4; i++){
                int x = t.x+dx[i];
                int y = t.y+dy[i];
                if(x<0 || x>=n || y<0 || y>=n){
                    cnt++;
                    continue;
                }
                if(g[x][y] == '#'){
                    cnt++;

                }
                if(cnt==4){
                    flag = true;
                }

                if( st[x][y] == true){
                    continue;
                }
                if(g[x][y] == '.'){
                    continue;
                }
                st[x][y] = true;
                q.add(new Pair(x, y));

            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n =Integer.parseInt(reader.readLine());
        String line;
        for(int i = 0; i<n; i++){
            line = reader.readLine();
            g[i] = line.toCharArray();

        }
        int res = 0;
        int cnt = 0;
        for(int i=0; i<n ;i++){
            for(int j = 0; j<n; j++){
                if(g[i][j] == '#' && st[i][j] == false){
                    res = 0;
                    res+=bfs(i, j);
                    System.out.println(res);
                    cnt++;
                    if(flag == true){
                        cnt--;
                        flag = false;
                    }
                }
            }
        }
        writer.write(cnt+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}