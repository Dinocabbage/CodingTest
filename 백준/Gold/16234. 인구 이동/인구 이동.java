import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] country;
    static boolean[][] isVisit;
    public static boolean populationMigration(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        List<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y});
        isVisit[x][y] = true;

        int totalPopulation = country[x][y];
        int count = 1;

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisit[nx][ny]) {
                    int difference = Math.abs(country[current[0]][current[1]] - country[nx][ny]);

                    if(difference >= L && difference <= R) {
                        isVisit[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        totalPopulation += country[nx][ny];
                        union.add(new int[] {nx, ny});
                        count++;
                    }
                }
            }
        }

        if(count > 1) {
            int averagePopulation = totalPopulation / count;

            for(int[] population : union) {
                country[population[0]][population[1]] = averagePopulation;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[N][N];

        for(int i = 0; i < N; i++) {
            country[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int day = 0;
        boolean canMove;

        while(true) {
            canMove = false;
            isVisit = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!isVisit[i][j]) {
                        if(populationMigration(i, j)) {
                            canMove = true;
                        }
                    }
                }
            }

            if(!canMove) {
                break;
            }

            day++;
        }

        bw.write(String.valueOf(day));

        bw.flush();
        bw.close();
        br.close();
    }
}
