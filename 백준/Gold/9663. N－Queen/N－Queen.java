import java.io.*;

public class Main {
    private static int N, count;
    private static int[] queens;

    public static void placeQueens(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isPlaceable(row, col)) {
                queens[row] = col;
                placeQueens(row + 1);
            }
        }
    }

    public static boolean isPlaceable(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        queens = new int[N];
        count = 0;

        placeQueens(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
