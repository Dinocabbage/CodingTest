import java.io.*;
import java.util.*;

public class Main {
    public static int getRelationNum(int start, int end, boolean[] isVisit, ArrayList<Integer>[] list) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        isVisit[start] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int current = queue.poll();

                if(current == end) {
                    return count;
                }

                for(int relation : list[current]) {
                    if(!isVisit[relation]) {
                        queue.offer(relation);
                        isVisit[relation] = true;
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

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        boolean[] isVisit = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int answer = getRelationNum(start, end, isVisit, list);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
