



import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:xie-super
 * Time:2022/2/27
 * Name:789. 数的范围
 */
public class _789 {

    private static final int N = 100010;

    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);

        int q = Integer.parseInt(s.split(" ")[1]);



        for(int i = 0; i<n;i++){
            s = reader.readLine();
            int n = Integer.parseInt(s.split(" ")[i]);

            list.add(n);
        }

        for(int i = 0; i<q; i++){
            s = reader.readLine();

            int num = reader.read();
            if(!list.contains(num)){
                writer.write(-1+" "+-1);
                writer.write("\n");

            }
            else {
                int start = list.indexOf(num);
                int end = list.lastIndexOf(num);
                writer.write(start+" "+end);
                writer.write("\n");

            }

        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
