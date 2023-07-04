import java.io.*;

public class Main {
    private static int N, count;
    private static int upperLimit;

    public static void placeQueens(int row, int ld, int rd) {
        if (row == upperLimit) {
            count++;
            return;
        }

        int availablePositions = upperLimit & (~(row | ld | rd));
        while (availablePositions > 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions -= position;
            placeQueens(row | position, (ld | position) << 1, (rd | position) >> 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        count = 0;
        upperLimit = (1 << N) - 1;

        placeQueens(0, 0, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
