import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String answer = "";

        for(int i = 0; i < n / 4; i++) {
            answer += "long ";
        }
        answer += "int";

        System.out.println(answer);
    }
}