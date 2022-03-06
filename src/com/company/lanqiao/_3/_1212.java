package com.company.lanqiao._3;

import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/4
 * Name:AcWing 1212. 地宫取宝
 * Method:DP, 状态表示f(i,j,c,v)，集合：表示从原点走到（i,j)坐标，已经取了k件物品，且最大价值为v的方案数集合，
 * 状态计算，分为到达(i,j)后拿了宝贝和没拿宝贝两种情况,初始状态表示f(1,1,0,-1),f(1,1,1,w[1][1]),前后分别表示没拿与拿了起点的宝贝，没拿时价值为-1的原因为可能第一件宝贝的价值为0,因为f集合表达的是一种解决方案，
 * f(1,1,0,-1)即第一件物品没拿其实价值大小对求解此题没有yingxiang
 */
public class _1212 {
    private static final int N = 55, MOD = 1000000007;
    public static int[][] w = new int[N][N];//存放价值
    public static int[][][][] f =new int[N][N][13][14];

    static int n,m,k;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        k = input.nextInt();

        for(int i = 1; i<=n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = input.nextInt();
                w[i][j]++;//防止开始价值为-1
            }
        }
        //初始状态赋值
        f[1][1][0][0] = 1;
        f[1][1][1][w[1][1]] = 1;//选与不选第一件宝贝的方案都为1

        for(int i = 1;i<=n;i++){
            for(int j = 1; j<=m;j++){
                if(i==1&&j==1){
                    continue;
                }
                for(int c = 0; c<=k; c++){
                    for(int v= 0; v<=13;v++){
                        //没有取当前（i，j)坐标宝贝
                        f[i][j][c][v] = (f[i][j][c][v]+f[i-1][j][c][v])%MOD;
                        f[i][j][c][v] = (f[i][j][c][v]+f[i][j-1][c][v])%MOD;
                        //取当前的宝贝，条件是此状态下已有宝贝，并且此坐标下的宝贝价值恰好为v
                        if(c>0 && w[i][j]==v){
                            //拿了此间宝贝，此时集合应更新为取得宝贝数量为c-1价值小于当前宝贝的价值的状态的总和
                            for(int v1 = 0; v1<v; v1++){
                                f[i][j][c][v] = (f[i-1][j][c-1][v1]+f[i][j][c][v])%MOD;
                                f[i][j][c][v] = (f[i][j-1][c-1][v1]+f[i][j][c][v])%MOD;

                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int v = 0; v<=13;v++){
            res = (res+f[n][m][k][v])%MOD;
        }
        System.out.println(res);

    }

}

