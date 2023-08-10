import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] coins = {25, 10, 5, 1};

        for(int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            int[] answer = new int[4];

            for(int j = 0; j < 4; j++) {
                int quantity = C / coins[j];

                answer[j] = quantity;
                C -= coins[j] * quantity;
            }

            bw.write(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            bw.newLine();
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

