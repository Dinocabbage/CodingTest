import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx, dy;
    public static String toBeaver(int[] beaver, int[] hedgehog, Queue<int[]> water) {
        Queue<int[]> move = new LinkedList<>();
        move.offer(hedgehog);

        map[hedgehog[0]][hedgehog[1]] = ',';

        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        int answer = 0;

        while(!move.isEmpty()) {
            answer++;

            int len = move.size();
            for(int i = 0; i < len; i++) {
                int[] coordinate = move.poll();

                for(int j = 0; j < 4; j++) {
                    int x = coordinate[0] + dx[j];
                    int y = coordinate[1] + dy[j];

                    if(x == beaver[0] && y == beaver[1]) {
                        return String.valueOf(answer);
                    }
                    if(x >= 0 && x < R && y >= 0 && y < C && map[x][y] == '.' && isMovable(x, y)) {
                        map[x][y] = ',';
                        move.offer(new int[]{x, y});
                    }
                }
            }

            int waterLen = water.size();
            for(int i = 0; i < waterLen; i++) {
                int[] coordinate = water.poll();

                for(int j = 0; j < 4; j++) {
                    int x = coordinate[0] + dx[j];
                    int y = coordinate[1] + dy[j];

                    if(x >= 0 && x < R && y >= 0 && y < C && (map[x][y] == '.' || map[x][y] == ',')) {
                        map[x][y] = '*';
                        water.offer(new int[]{x, y});
                    }
                }
            }
        }

        return "KAKTUS";
    }

    public static boolean isMovable(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '*') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        int[] beaver = new int[2];
        int[] hedgehog = new int[2];

        Queue<int[]> water = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'D') {
                    beaver[0] = i;
                    beaver[1] = j;
                }

                if(map[i][j] == 'S') {
                    hedgehog[0] = i;
                    hedgehog[1] = j;
                }
                else if(map[i][j] == '*') {
                    water.offer(new int[] {i, j});
                }
            }
        }

        bw.write(toBeaver(beaver, hedgehog, water));

        bw.flush();
        bw.close();
    }
}
