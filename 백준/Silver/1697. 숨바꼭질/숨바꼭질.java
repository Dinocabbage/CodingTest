import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer;
    static boolean[] isVisit;

    public static void hideAndSeek() {
        if(N == K) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        isVisit[N] = true;

        while(!queue.isEmpty()) {
            answer++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int n = queue.poll();
                int[] next = {1, -1, n};

                for(int j = 0; j < 3; j++) {
                    int k = n + next[j];

                    if(k == K) {
                        return;
                    }
                    if(k > 0 && k < 100001 && !isVisit[k]) {
                        isVisit[k] = true;
                        queue.offer(k);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisit = new boolean[100001];
        answer = 0;

        hideAndSeek();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }
}
