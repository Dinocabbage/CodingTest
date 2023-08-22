import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int[][] sudoku;
    static boolean[][] rowUsed, colUsed;
    static boolean[][][] boxUsed;

    public static boolean solveSudoku(int row, int col) {
        if (row == 9) {
            return true; // 스도쿠가 모두 채워진 경우
        }

        if (col == 9) {
            return solveSudoku(row + 1, 0); // 현재 행이 끝난 경우 다음 행으로 이동
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(row, col + 1); // 이미 숫자가 채워진 경우 다음 열로 이동
        }

        for (int num = 1; num <= 9; num++) {
            if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[row / 3][col / 3][num]) {
                sudoku[row][col] = num;
                rowUsed[row][num] = true;
                colUsed[col][num] = true;
                boxUsed[row / 3][col / 3][num] = true;

                if (solveSudoku(row, col + 1)) {
                    return true; // 스도쿠가 해결되었을 경우
                }

                // 백트래킹
                sudoku[row][col] = 0;
                rowUsed[row][num] = false;
                colUsed[col][num] = false;
                boxUsed[row / 3][col / 3][num] = false;
            }
        }

        return false; // 가능한 숫자가 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int[9][9];
        rowUsed = new boolean[9][10];
        colUsed = new boolean[9][10];
        boxUsed = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                sudoku[i][j] = num;

                if (num != 0) {
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3][j / 3][num] = true;
                }
            }
        }

        solveSudoku(0, 0);

        for(int i = 0; i < 9; i++) {
            bw.write(Arrays.stream(sudoku[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
