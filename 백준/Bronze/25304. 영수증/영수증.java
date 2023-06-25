import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int n = sc.nextInt();
        String answer = "No";

        for(int i = 0; i < n; i++) {
            total -= sc.nextInt() * sc.nextInt();
        }

        if(total == 0) {
            answer = "Yes";
        }

        System.out.println(answer);
    }
}