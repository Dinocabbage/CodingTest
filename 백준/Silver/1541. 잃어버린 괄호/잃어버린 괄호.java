import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("-");
        int answer = Arrays.stream(arr[0].split("\\+")).mapToInt(Integer::parseInt).sum();

        for(int i = 1; i < arr.length; i++) {
            answer -= Arrays.stream(arr[i].split("\\+")).mapToInt(Integer::parseInt).sum();
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}