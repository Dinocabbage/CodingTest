import java.util.Scanner;

public class Main {

    public int calculate(int k, int n) {
        if(k == 0) {
            return n;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            return calculate(k - 1, n) + calculate(k, n - 1);
        }
    }

    public static void main(String[] args) {
        Main b = new Main();

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(b.calculate(k, n));
        }
    }
}
