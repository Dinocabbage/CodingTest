import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[b];
        int num = 1;
        int count = 0;

        for(int i = 0; i < b; i++) {
            arr[i] = num;
            count++;

            if(count == num) {
                num++;
                count = 0;
            }
        }

        for(int i = a - 1; i < b; i++) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
