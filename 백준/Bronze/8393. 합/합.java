import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = n - 1; i > 0; i--) {
            n += i;
        }

        System.out.println(n);
    }
}