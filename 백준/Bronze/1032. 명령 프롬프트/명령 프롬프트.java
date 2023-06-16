import java.util.Scanner;

public class Main {
    public String solution(String[] input, int n) {
        char[] answer = input[0].toCharArray();

        if(n == 1) {
            return input[0];
        }
        else {
            for(int i = 1; i < input.length; i++) {
                for(int j = 0; j < input[0].length(); j++) {
                    if(answer[j] != input[i].charAt(j)) {
                        answer[j] = '?';
                    }
                }
            }
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        Main b = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];

        for(int i = 0; i < n; i++) {
            input[i] = sc.next();
        }

        System.out.println(b.solution(input, n));
    }
}
