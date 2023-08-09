import java.io.*;
import java.util.*;

public class Main {
    private static int getInviteNum(int start, ArrayList<Integer>[] graph, boolean[] visited, boolean[] isFriend) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if(isFriend[currentNode]) {
                for (int neighbor : graph[currentNode]) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] isFriend = new boolean[n + 1];
        isFriend[1] = true;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);

            if(a == 1) {
                isFriend[b] = true;
            }
        }
        
        boolean[] visited = new boolean[n + 1];
        int inviteCount = getInviteNum(1, graph, visited, isFriend);

        bw.write(String.valueOf(inviteCount));

        bw.flush();
        bw.close();
        br.close();
    }
}
