import java.io.*;
import java.util.*;

public class Main {
    public static int bfs(int F, int S, int G, int U, int D) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(S);
        boolean[] isVisit = new boolean[F + 1];
        isVisit[S] = true;
        int answer = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int current = queue.poll();

                if(current == G) {
                    return answer;
                }

                int up = current + U;
                int down = current - D;

                if(up <= F && !isVisit[up]) {
                    isVisit[up] = true;
                    queue.offer(up);
                }

                if(down > 0 && !isVisit[down]) {
                    isVisit[down] = true;
                    queue.offer(down);
                }
            }
            
            answer++;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int answer = bfs(F, S, G, U, D);

        if(answer == -1) {
            bw.write("use the stairs");
        }
        else {
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}