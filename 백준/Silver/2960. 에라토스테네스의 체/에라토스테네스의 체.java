import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int[] arr = new int[n + 1];

        for(int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        boolean isEnded = false;
        int count = 0;
        int answer = 0;
        int primeNum = 1;
        while(!isEnded) {
            primeNum += 1;
            for(int i = primeNum; i < arr.length; i++) {
                if(arr[i] % primeNum == 0) {
                    count++;
                    arr[i] = -1;
                }
                if(count == k) {
                    answer = i;
                    isEnded = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
