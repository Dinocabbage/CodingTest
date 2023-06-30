import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> gift = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];

            if(a == 0) {
                if(gift.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                }
                else {
                    bw.write(String.valueOf(gift.poll()));
                    bw.newLine();
                }
            }
            else {
                for(int j = 1; j < input.length; j++) {
                    gift.offer(input[j]);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
