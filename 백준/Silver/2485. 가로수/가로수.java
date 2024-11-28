import java.io.*;

public class Main {
    private static int getGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] trees = new int[N];

        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[] treeGaps = new int[N - 1];

        for(int i = 0; i < N - 1; i++) {
            treeGaps[i] = trees[i + 1] - trees[i];
        }

        int gcdValue = treeGaps[0];

        for(int i = 1; i < N - 1; i++) {
            gcdValue = getGCD(gcdValue, treeGaps[i]);
        }

        int answer = 0;

        for(int treeGap : treeGaps) {
            answer += (treeGap / gcdValue) - 1;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
