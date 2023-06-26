import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxScore = Arrays.stream(arr).max().getAsInt();

        bw.write(String.valueOf(Arrays.stream(arr).mapToDouble(i -> (double)i / maxScore * 100).average().getAsDouble()));

        bw.flush();
        bw.close();
        br.close();
    }
}