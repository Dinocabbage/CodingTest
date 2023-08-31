import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int M, N;
    private static int[][] paper;
    private static boolean[][] isVisit;
    private static List<Integer> areaSizes;

    private static int findArea(int row, int col) {
        if(row < 0 || row >= N || col < 0 || col >= M || isVisit[row][col] || paper[row][col] == 1) {
            return 0;
        }

        isVisit[row][col] = true;

        return findArea(row - 1, col) + findArea(row + 1, col) + findArea(row, col - 1) + findArea(row, col + 1) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        isVisit = new boolean[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    paper[x][y] = 1;
                }
            }
        }

        areaSizes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(paper[i][j] == 0 && !isVisit[i][j]) {
                    areaSizes.add(findArea(i, j));
                }
            }
        }

        bw.write(areaSizes.size() + "\n");
        bw.write(areaSizes.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));

        bw.flush();
        bw.close();
        br.close();
    }
}
