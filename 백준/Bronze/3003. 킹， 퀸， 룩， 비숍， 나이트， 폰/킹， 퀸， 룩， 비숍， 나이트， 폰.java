import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answer = {1, 1, 2, 2, 2, 8};
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < 6; i++) {
            answer[i] -= input[i];
        }

        bw.write(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        bw.flush();
        bw.close();
        br.close();
    }
}
