import java.io.*;
import java.util.*;

class Point {
    private int x, y, z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }
}

public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M, N, H, days;
    static int[][][] tomatoes;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];
        Queue<Point> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomatoes[h][i][j] = Integer.parseInt(st.nextToken());
                    if (tomatoes[h][i][j] == 1) {
                        queue.offer(new Point(j, i, h));
                    }
                }
            }
        }

        bfs(queue);

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomatoes[h][i][j] == 0) {
                        days = -1;
                    }
                }
            }
        }

        bw.write(String.valueOf(days));

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(Queue<Point> queue) {
        days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int x = point.getX();
                int y = point.getY();
                int z = point.getZ();

                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && tomatoes[nz][ny][nx] == 0) {
                        tomatoes[nz][ny][nx] = 1;
                        queue.offer(new Point(nx, ny, nz));
                    }
                }
            }
            days++;
        }
    }
}
