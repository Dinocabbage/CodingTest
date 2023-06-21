import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] factorial, combination, answer;
    private static int N, F;
    private static boolean[] check;
    private static boolean isFinish;

    public static void solution(int index, int result) {
        if(isFinish || result > F) { // 계산이 끝났거나, 더한 값이 F보다 커졌을 경우 return
            return;
        }
        if(index == N) { // index가 N에 도달했을 경우
            if(result == F) { // 더한 값이 F와 같을 경우 출력 후 isFinish를 true로 초기화(계산 끝)
                for(int i = 0; i < N; i++) {
                    System.out.print(answer[i] + " ");
                }
                isFinish = true;
            }
        }

        for(int i = 1; i <= N; i++) {
            if(!check[i]) { // 첫번째 열에 i를 넣었는지 체크
                check[i] = true; // 넣었다고 표시
                answer[index] = i; // 0번째에 i를 넣어봄

                // 수가 N개 있을 때 수열의 k번째로 적힌 수(index)는 최종 수에 (N-1)Ck번 더해진다.
                solution(index + 1, result + combination[index] * i);
                if(isFinish) { // 끝났으면 break;
                    break;
                }
                check[i] = false; // 안끝났으면 check[i]를 다시 false로 변경
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        F = Integer.parseInt(input[1]);

        br.close();

        factorial = new int[N];
        combination = new int[N];
        check = new boolean[N + 1];
        answer = new int[N];
        factorial[0] = 1;

        // setFactorial
        for(int i = 1; i < N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // setCombination
        // nCr = n! / r!(n - r)! -> 조합의 경우의 수를 구하는 공식, n개 중 서로 다른 r개를 선택하되 순서를 고려하지 않는 것을 말함
        for(int i = 0; i < N; i++) {
            combination[i] = factorial[N - 1] / (factorial[i] * factorial[N - 1 - i]);
        }

        solution(0, 0);
    }
}
