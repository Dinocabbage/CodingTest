import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringBuilder sb;

    public static void solution(int startNum, int index, String answer) {
        if(index == M) {
            sb.append(answer + "\n");
        }
        else {
            for(int i = startNum; i <= N; i++) {
                solution(i + 1, index + 1, answer + i + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        solution(1, 0, "");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
