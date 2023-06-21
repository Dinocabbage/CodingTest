import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(int k, ArrayList<Integer> ryanIndex) {
        int answer = Integer.MAX_VALUE;

        if(ryanIndex.size() >= k) {
            for(int i = 0; i <= ryanIndex.size() - k; i++) {
                answer = Math.min(answer, ryanIndex.get(i + k - 1) - ryanIndex.get(i) + 1);
            }

            return answer;
        }

        return -1;
    }

    public static void main(String[] args) {
        Main b = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dolls = new int[n];
        ArrayList<Integer> ryanIndex = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            dolls[i] = sc.nextInt();
            if(dolls[i] == 1) {
                ryanIndex.add(i);
            }
        }

        System.out.println(b.solution(k, ryanIndex));
    }
}
