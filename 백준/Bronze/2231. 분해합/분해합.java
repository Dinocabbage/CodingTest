import java.io.*;
import java.util.Arrays;

public class Main {
    private static int findCreator(int N) {
        int answer = 0;

        for(int i = 1; i < N; i++) {
            int[] arr = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();

            int sum = i + Arrays.stream(arr).sum();

            if(sum == N) {
                answer = i;

                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(findCreator(N)));

        bw.flush();
        bw.close();
        br.close();
    }
}