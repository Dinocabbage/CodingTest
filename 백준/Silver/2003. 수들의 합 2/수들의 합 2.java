import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int N, int M, int[] A) {
        int answer = 0, total;

        for(int i = 0; i < N; i++) {
            total = A[i];

            if(A[i] == M) {
                answer++;
                continue;
            }

            for(int j = i + 1; j < N; j++) {
                total += A[j];
                if(total >= M) {
                    if(total == M) {
                        answer++;
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(N, M, A));
    }
}
