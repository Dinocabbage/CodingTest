import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;  // 무방향 그래프에서 양쪽 방향으로 연결
        }

        dfs(V, bw);
        bw.newLine();
        bfs(V, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, BufferedWriter bw) throws IOException {
        isVisit[start] = true;
        bw.write(start + " ");

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !isVisit[i]) {
                dfs(i, bw);
            }
        }
    }

    public static void bfs(int start, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisit[start] = false;  // bfs에서 방문 여부를 다시 false로 변경

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bw.write(current + " ");

            for (int i = 1; i < graph.length; i++) {
                if (graph[current][i] == 1 && isVisit[i]) {
                    queue.offer(i);
                    isVisit[i] = false;  // 방문한 정점을 다시 방문하지 않도록 방문 여부 변경
                }
            }
        }
    }
}
