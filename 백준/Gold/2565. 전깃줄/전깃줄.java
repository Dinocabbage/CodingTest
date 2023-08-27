import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Wire {
    private int start;
    private int end;

    Wire(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Wire[] wires = new Wire[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(wires, Comparator.comparing(Wire::getStart));

        int[] dp = new int[N];
        dp[0] = 1;

        int longest = 1;

        for(int i = 1; i < N; i++) {
            int max = 0;

            for(int j = 0; j < i; j++) {
                if(wires[i].getEnd() > wires[j].getEnd() && dp[j] > max) {
                    max = dp[j];
                }
            }

            dp[i] = max + 1;
            longest = Math.max(longest, dp[i]);
        }

        bw.write(String.valueOf(N - longest));

        bw.flush();
        bw.close();
        br.close();
    }
}
