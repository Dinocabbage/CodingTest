import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int w, h;

    public static void checkIsland(int x, int y) {
        map[x][y] = 0;

        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                checkIsland(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for(int x = 0; x < h; x++) {
                for(int y = 0; y < w; y++) {
                    if(map[x][y] == 1) {
                        count++;
                        checkIsland(x, y);
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
