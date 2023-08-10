import java.io.*;
import java.util.*;

public class Main {
    public static int getKnightMoveCount(int l, int[] start, int[] end, boolean[][] isVisit) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        isVisit[start[0]][start[1]] = true;

        int[] dx = {2, 2, 1, 1, -2, -2, -1, -1};
        int[] dy = {1, -1, 2, -2, 1, -1, 2, -2};

        int count = 0;


        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int[] current = queue.poll();

                if(current[0] == end[0] && current[1] == end[1]) {
                    return count;
                }

                for(int j = 0; j < 8; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if(nx >= 0 && nx < l && ny >= 0 && ny < l && !isVisit[nx][ny]) {
                        queue.offer(new int[] {nx, ny});
                        isVisit[nx][ny] = true;
                    }
                }
            }

            count++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());

            boolean[][] isVisit = new boolean[l][l];

            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int count = getKnightMoveCount(l, start, end, isVisit);

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
