import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int[][] map;
    private static int N;
    private static boolean[][] isVisit;
    private static List<Integer> placeSizes;

    private static int findPlace(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N || isVisit[row][col] || map[row][col] == 0) {
            return 0;
        }

        isVisit[row][col] = true;

        int size = 1;
        size += (findPlace(row - 1, col) + findPlace(row + 1, col) + findPlace(row, col - 1) + findPlace(row, col + 1));

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        br.close();

        int placeCount = 0;
        placeSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisit[i][j]) {
                    int complexSize = findPlace(i, j);
                    placeSizes.add(complexSize);
                    placeCount++;
                }
            }
        }

        bw.write(String.valueOf(placeCount));
        bw.newLine();
        bw.write(placeSizes.stream().sorted().map(String::valueOf).collect(Collectors.joining("\n")));

        bw.flush();
        bw.close();
    }
}
