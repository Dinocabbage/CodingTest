import java.io.*;
import java.util.*;

public class Main {
    public static int findWay(int N, int M, int[][] maze) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        maze[0][0] = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int answer = 1;

        while(!queue.isEmpty()) {
            answer++;
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int[] coordinates = queue.poll();

                for(int j = 0; j < 4; j++) {
                    int x = coordinates[0] + dx[j];
                    int y = coordinates[1] + dy[j];

                    if(x == N - 1 && y == M - 1) {
                        return answer;
                    }
                    if(x >= 0 && x < N && y >= 0 && y < M && maze[x][y] == 1) {
                        maze[x][y] = 0;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];

        for(int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(String.valueOf(findWay(N, M, maze)));

        bw.flush();
        bw.close();
    }
}
