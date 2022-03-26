import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int l = input.nextInt();
        int r = input.nextInt();
        int n = r-l;

        BigDecimal b = BigDecimal.valueOf(n-l+1);


        BigDecimal one = b.divide(BigDecimal.valueOf(2));

        BigDecimal two = BigDecimal.valueOf(n-l+2);
        BigDecimal res = one.multiply(two);
        long lr = res.setScale( 0, BigDecimal.ROUND_UP ).longValue();

        System.out.println(lr);
    }
}