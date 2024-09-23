import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int findCombination(int N, int M, int[] cards) {
        int answer = 0;

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if(sum <= M && sum > answer) {
                        answer = sum;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bw.write(String.valueOf(findCombination(N, M, cards)));

        bw.flush();
        bw.close();
        br.close();
    }
}