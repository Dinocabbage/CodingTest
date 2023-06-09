import java.util.Scanner;

public class Main {

    public int solution(String[] input) {
        int answer = 0;

        boolean[] checker = new boolean[26];

        for(String s : input) {
            answer++;
            for(int i = 0; i < s.length(); i++) {
                if(!checker[s.charAt(i) - 97]) {
                    checker[s.charAt(i) - 97] = true;
                }
                else if(s.charAt(i) != s.charAt(i - 1)) {
                    answer--;
                    break;
                }
            }
            checker = new boolean[26];
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String [] input = new String[num];
        for(int i = 0; i < num; i++) {
            input[i] = sc.next();
        }
        sc.close();

        System.out.println(T.solution(input));
    }
}
