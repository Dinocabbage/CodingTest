import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[101][101];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int tx = x + 10;
            int y = Integer.parseInt(st.nextToken());
            int ty = y + 10;

            for(int j = x; j < tx; j++) {
                for(int k = y; k < ty; k++) {
                    board[j][k] = 1;
                }
            }
        }

        bw.write(String.valueOf(Arrays.stream(board).flatMapToInt(row -> Arrays.stream(row)).sum()));

        bw.flush();
        bw.close();
        br.close();
    }
}
