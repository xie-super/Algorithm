import java.util.Scanner;

public class Main{
    private static int N =  2000000;
    static int[] a = new int[N];
    static int[] sum = new int[N];
    static int n,first, second;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        first = input.nextInt();
        second = input.nextInt();
        for(int i = 1; i<=n ; i++){
            if(i == first){
                continue;
            }
            for(int j = 1; j<=n ; j++){
                if(j == second){
                    continue;
                }
                a[i+j]++;

            }
        }
        for(int i = 2; i<=2*n; i++){
            sum[i] = sum[i-1]+a[i];
        }

        int finalRes = first+second;
        int one;
        int two;
        int back = sum[2*n]-sum[finalRes-1];
        if(back>=n-1){
            one = 1;
        }else {
            one = n - back;
        }
        int front = sum[finalRes];
        System.out.println(front);
        if(front>=n-1){
            two = n;
        }else {
            two = front+1;
        }

        System.out.println(one+" "+two);



    }

}