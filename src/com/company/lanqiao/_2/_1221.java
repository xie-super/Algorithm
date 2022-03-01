package com.company.lanqiao._2;

import java.util.*;

/**
 * Author:xie-super
 * Time:2022/3/1
 * Name:AcWing 1221. 四平方和
 * Nethod : 哈希或二分
 */
public class _1221 {

      static Set<Integer> set = new HashSet<>();
      private static final int N = 5000010;
      static int[][] pair = new int[N][2];
      static int num;
      //哈希方法，对半砍，利用哈希表存储一半的结果
      static void hashMethod(){
          for(int i = 0; i<=num; i++){
              for(int j = i; i*i+j*j<=num; j++){
                  int sum = i*i+j*j;
                  if(!set.contains(sum)){
                      set.add(sum);
                      try {
                          pair[sum][0] = i;
                          pair[sum][1] = j;
                      }catch (ArrayIndexOutOfBoundsException e){
                          System.out.println(sum);
                      }

                  }
              }
          }

          for(int i = 0; i<=num; i++){
              for(int j = i; i*i+j*j<=num; j++){
                  int sub = num - i*i-j*j;
                  if(set.contains(sub)){
                      System.out.println(i+" "+j+" "+pair[sub][0]+" "+pair[sub][1]);
                      return;
                  }


              }
          }
      }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        num = input.nextInt();
       hashMethod();


    }

}
