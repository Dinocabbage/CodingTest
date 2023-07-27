import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        int[] result = new int[N];

        for(int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(result);

        for(int i = 0; i < N; i++) {
            answer += Math.abs(result[i] - (i + 1));
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
