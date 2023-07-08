import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] isUsed = new boolean[100001];
        long count = 0;

        for(int left = 0, right = -1; left < N; left++) {
            while (right + 1 < N && !isUsed[numbers[right + 1]]) {
                right++;
                isUsed[numbers[right]] = true;
            }

            count += right - left + 1;

            isUsed[numbers[left]] = false;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}