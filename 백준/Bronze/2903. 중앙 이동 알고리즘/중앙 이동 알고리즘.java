import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        arr[0] = 2;

        for(int i = 1; i < N + 1; i++) {
            arr[i] = arr[i - 1] * 2 - 1;
        }

        bw.write(String.valueOf(arr[N] * arr[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
