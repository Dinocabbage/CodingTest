import java.io.*;
import java.util.Arrays;

public class Main {
    private static int findCreator(int N) {
        for(int i = 1; i < N; i++) {
            int sum = i;
            int temp = i;

            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(sum == N) {
                return i;
            }
        }

        return 0;
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