import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pq.isEmpty()) {
                    bw.write("0");
                }
                else {
                    bw.write(String.valueOf(pq.poll()));
                }

                bw.newLine();
            }
            else {
                pq.offer(input);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
