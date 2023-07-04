import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        bw.close();
        br.close();
    }
}
