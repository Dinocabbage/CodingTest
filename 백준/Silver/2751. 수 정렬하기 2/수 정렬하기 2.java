import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Arrays.stream(numbers).sorted().mapToObj(String::valueOf).collect(Collectors.joining("\n")));

        bw.flush();
        bw.close();
        br.close();
    }
}