import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n + 1];
        int[] dy = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dy[1] = wines[1];

        if(n > 1) {
            dy[2] = wines[1] + wines[2];
        }

        for(int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 1], Math.max(dy[i - 2] + wines[i], dy[i - 3] + wines[i - 1] + wines[i]));
        }

        bw.write(String.valueOf(dy[n]));

        bw.flush();
        bw.close();
        br.close();

    }
}
