import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] cx = new int[N];
        int[] cy = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cx[i] = Integer.parseInt(st.nextToken());
            cy[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cx);
        Arrays.sort(cy);

        bw.write(String.valueOf((cx[N - 1] - cx[0]) * (cy[N - 1] - cy[0])));

        bw.flush();
        bw.close();
        br.close();
    }
}
