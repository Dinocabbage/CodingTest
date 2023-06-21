import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] answer = new int[n + 1];
        if(n == 0) {
            System.out.println(0);
        }

        if(n >= 1) {
            answer[1] = 1;
        }

        if(n >= 2) {
            answer[2] = 2;
        }

        if(n >= 3) {
            for(int i = 3; i <= n; i++) {
                answer[i] = (answer[i - 1] + answer[i - 2]) % 15746;
            }
        }
        if(n > 0) {
            System.out.println(answer[n]);
        }
    }
}
