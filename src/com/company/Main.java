package com.company;
import java.io.BufferedReader;
import java.util.*;
public  class Main{
    static int count = 0;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        Set<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i<n;i++){
            int temp = scanner.nextInt();
            set.add(temp);
            count++;
            //判断有无重复
            if(set.size() == count){
                continue;
            }else{
                //记录此时不重复子序列
                if(max<set.size()){
                    max = set.size();

                }
                set.clear();
                set.add(temp);
                count = 1;
            }


        }
        if(count>max){
            max = count;
        }

        System.out.print(max);



    }
}