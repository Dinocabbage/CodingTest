import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] cabbageField;
    public static void solution(int n, int m) {
        cabbageField[n][m] = 0;

        int[] dn = {1, -1, 0, 0};
        int[] dm = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++) {
            int nn = n + dn[i];
            int nm = m + dm[i];

            if(nn >= 0 && nn < N && nm >= 0 && nm < M && cabbageField[nn][nm] == 1) {
                solution(nn, nm);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int answer = 0;

            cabbageField = new int[N][M];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                cabbageField[n][m] = 1;
            }

            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(cabbageField[n][m] == 1) {
                        solution(n, m);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
