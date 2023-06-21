import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] ryanIndex = new int[n + 2];
        int count = 0;
        int answer = n + 1;

        for(int i = 0; i < n; i++) {

            if(sc.nextInt() == 1) {
                ryanIndex[count++] = i;

                if(count >= k) {
                    answer = Math.min(answer, ryanIndex[count - 1] - ryanIndex[count - k] + 1);
                }
            }
        }

        if(answer == n + 1) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }
}
