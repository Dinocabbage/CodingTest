import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[5];

        for(int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.stream(numbers).sum() / 5).append("\n");

        sb.append(numbers[2]);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}