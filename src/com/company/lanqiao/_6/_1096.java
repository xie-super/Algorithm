package com.company.lanqiao._6;
import java.io.*;
import java.util.*;
/**
 * Author:xie-super
 * Time:2022/3/26
 * Name:1096. 地牢大师
 * Method:bfs
 */
public class _1096 {
    private static final int N = 110;
    static char g[][][] = new char[N][N][N];
    static int dist[][][] = new int[N][N][N];
    static int[] dx = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 0, 0, 1, -1};
    static int[] dz = new int[]{0, 0, -1, 1, 0, 0};

    static int l, r, c;

    static int bfs(Pair start, Pair end){
        for(int x = 0; x<l; x++){
            for(int y = 0; y<r; y++){
                Arrays.fill(dist[x][y], -1);
            }
        }
        dist[start.x][start.y][start.z]  = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Pair t = q.poll();

            for(int i = 0; i<6; i++){
                int x = t.x+dx[i];
                int y = t.y+dy[i];
                int z = t.z+dz[i];

                if(x<0 || x>=l || y<0 || y>=r || z<0 || z>=c){
                    continue;
                }
                if(g[x][y][z] == '#'){
                    continue;
                }
                if(dist[x][y][z] != -1){
                    continue;
                }
                dist[x][y][z] = dist[t.x][t.y][t.z]+1;
                if(x == end.x && y == end.y && z == end.z){
                    return dist[x][y][z];
                }

                q.add(new Pair(x, y, z));
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sp;
        while (true) {
            sp = reader.readLine().split(" ");
            l = Integer.parseInt(sp[0]);
            r = Integer.parseInt(sp[1]);
            c = Integer.parseInt(sp[2]);
            if (l == 0 && r == 0 && c == 0) {
                return;
            }
            String line;
            for (int x = 0; x < l; x++) {
                for (int y = 0; y < r; y++) {
                    line = reader.readLine();
                    g[x][y] = line.toCharArray();
                }
                reader.readLine();
            }
            Pair start = new Pair();
            Pair end = new Pair();
            for (int x = 0; x < l; x++) {
                for (int y = 0; y < r; y++) {
                    for (int z = 0; z < c; z++) {
                        if (g[x][y][z] == 'S') {
                            start.x = x;
                            start.y = y;
                            start.z = z;
                        }
                        if (g[x][y][z] == 'E') {
                            end.x = x;
                            end.y = y;
                            end.z = z;
                        }
                    }
                }
            }
            int dis = bfs(start, end);
            if (dis == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + dis + " minute(s).");
            }

        }

    }




}

class Pair{
    public int x;
    public int y;
    public int z;
    Pair(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public Pair() {

    }
}