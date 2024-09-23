import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(input);

        if(input[2] >= input[0] + input[1]) {
            input[2] = input[0] + input[1] - 1;
        }

        bw.write(String.valueOf(Arrays.stream(input).sum()));

        bw.flush();
        bw.close();
        br.close();
    }
}