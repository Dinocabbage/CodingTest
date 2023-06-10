import java.util.Scanner;

public class Main {

    public void slideCandies(char[][] board, int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    public int getMaxEatableCandies(char[][] board) {
        int maxEatableCandies = 1;

        for (int x = 0; x < board.length; x++) {
            int count = 1;
            for (int y = 1; y < board.length; y++) {
                if (board[x][y] == board[x][y - 1]) {
                    count++;
                } else {
                    maxEatableCandies = Math.max(maxEatableCandies, count);
                    count = 1;
                }
            }
            maxEatableCandies = Math.max(maxEatableCandies, count);
        }

        for (int y = 0; y < board.length; y++) {
            int count = 1;
            for (int x = 1; x < board.length; x++) {
                if (board[x][y] == board[x - 1][y]) {
                    count++;
                } else {
                    maxEatableCandies = Math.max(maxEatableCandies, count);
                    count = 1;
                }
            }
            maxEatableCandies = Math.max(maxEatableCandies, count);
        }

        return maxEatableCandies;
    }

    public static void main(String[] args) {
        Main b = new Main();
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if(y + 1 < n && board[x][y] != board[x][y + 1]) {
                    b.slideCandies(board, x, y, x, y + 1);
                    answer = Math.max(b.getMaxEatableCandies(board), answer);
                    b.slideCandies(board, x, y, x, y + 1);
                }

                if(x + 1 < n && board[x][y] != board[x + 1][y]) {
                    b.slideCandies(board, x, y, x + 1, y);
                    answer = Math.max(b.getMaxEatableCandies(board), answer);
                    b.slideCandies(board, x, y, x + 1, y);
                }
            }
        }

        System.out.println(answer);
    }
}
