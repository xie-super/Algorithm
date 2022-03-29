package com.company.lanqiao._6;

import java.io.*;
import java.nio.Buffer;

/**
 * Author:xie-super
 * Time:2022/3/27
 * Name:1233. 全球变暖
 * Method: Flood Fill
 */
//DFS
public class _1233 {
    private static final int N = 1010;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int n;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean flag;
    static int dfs(int a, int b){
        if(st[a][b] == true){
            return 0; //0代表其以及其周围连接的岛屿已经搜过，且不管其能不能形成岛屿，都不再搜索
        }
        int res = 1;
        int cnt = 0; //cnt达到四，就不会被淹没
        st[a][b] = true;

        for(int i = 0; i<4 ;i++){
            int x = a+dx[i];
            int y = b+dy[i];
            if(x<0 || x>=n || y<0 || y>=n ){
                cnt++;
                continue;
            }
            if(g[x][y] == '#'){
                cnt++;
            }
            if(cnt ==4){
                flag = true;
                //System.out.println(a+""+b);
            }
            if( st[x][y] == true){
                continue;
            }
            if(g[x][y] == '.'){
                continue;
            }

            //连接的区域没有被搜过

            res+=dfs(x,y);
        }
        return res;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        String[] sp;
        String line;
        for(int i = 0; i<n ;i++){
            line = reader.readLine();
            g[i] = line.toCharArray();
        }
        int res = 0;
        //岛屿总数
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(g[i][j] == '#' && st[i][j] == false){
                    res = 0;
                    res += dfs(i, j);
                    //System.out.println(res);

                        cnt++;

                    if(flag == true){
                        cnt--;//此岛屿还存在
                        flag = false;
                    }
                }

            }
        }
        int i = 1;
        System.out.print(cnt);

        reader.close();

    }
}
