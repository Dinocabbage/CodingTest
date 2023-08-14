import java.io.*;
import java.util.*;

class Road {
    private int start;
    private int end;
    private int length;

    public Road(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public int getLength() {
        return this.length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Road> roads = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            roads.add(new Road(start, end, length));
        }

        Collections.sort(roads, Comparator.comparingInt(Road::getEnd));

        int[] dp = new int[D + 1];

        int j = 0;

        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1;

            for ( ; j < N; j++) {
                Road road = roads.get(j);
                if (road.getEnd() == i) {
                    dp[i] = Math.min(dp[i], dp[road.getStart()] + road.getLength());
                }
                else {
                    break;
                }
            }
        }

        bw.write(String.valueOf(dp[D]));

        bw.flush();
        bw.close();
        br.close();
    }
}
