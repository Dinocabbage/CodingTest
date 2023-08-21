import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> Math.abs((int)a)).thenComparingInt(a -> (int) a));

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0 && !pq.isEmpty()) {
                bw.write(pq.poll() + "\n");
            }
            else if(x == 0 && pq.isEmpty()) {
                bw.write("0\n");
            }
            else {
                pq.offer(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}