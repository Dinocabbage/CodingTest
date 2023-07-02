import java.io.*;

public class Main {
    private static int N, count;
    private static int[][] chessboard;

    private static void placeQueens(int col) {
        if (col == N) {
            count++;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isPlaceable(row, col)) {
                chessboard[row][col] = 1;
                placeQueens(col + 1);
                chessboard[row][col] = 0;
            }
        }
    }

    private static boolean isPlaceable(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        chessboard = new int[N][N];
        count = 0;
        placeQueens(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
