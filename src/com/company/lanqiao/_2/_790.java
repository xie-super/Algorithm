package com.company.lanqiao._2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/3/1
 * Name:790. 数的三次方根
 */
public class _790 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Double  num = input.nextDouble();

        Double left = -10000.0;
        Double right =10000.0;
        while(right - left > 1e-8){
            Double mid = (right+left)/2;
            if(mid * mid * mid >num)right = mid;
            else left = mid;
        }
        System.out.printf("%.6f",left);

    }
}
