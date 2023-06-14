import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(String input) {
        int[] arr = new int[input.length()];
        int count = 0;
        int index = 0;

        for(char c : input.toCharArray()) {
            if(c == 'O') {
                count++;
            }
            else {
                count = 0;
            }

            arr[index++] = count;
        }

        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {
        Main b = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String input = sc.next();

            System.out.println(b.solution(input));
        }
    }
}
