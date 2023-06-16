import java.util.Scanner;

public class Main {
    public String solution(String input) {
        int[] answer = new int[4];

        for(char c : input.toCharArray()) {
            if(Character.isLowerCase(c)) {
                answer[0]++;
            }
            else if(Character.isUpperCase(c)) {
                answer[1]++;
            }
            else if(Character.isDigit(c)) {
                answer[2]++;
            }
            else {
                answer[3]++;
            }
        }

        return answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3];
    }

    public static void main(String[] args) {
        Main b = new Main();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            System.out.println(b.solution(input));
        }
        sc.close();
    }
}
