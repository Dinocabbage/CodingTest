import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        double[] dx = new double[N + 1];
        double[] dy = new double[N + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            dx[i] = x;
            dy[i] = y;
        }

        dx[N] = dx[0];
        dy[N] = dy[0];

        double answer = 0;

        for(int i = 0; i < N; i++) {
            answer += dx[i] * dy[i + 1] - dy[i] * dx[i + 1];
        }

        bw.write(String.format("%.1f", Math.abs(answer) / 2));

        bw.flush();
        bw.close();
        br.close();
    }
}
