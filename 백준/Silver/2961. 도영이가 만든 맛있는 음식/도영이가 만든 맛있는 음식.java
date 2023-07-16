import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] sour;
    static int[] bitter;
    static int min, N;

    public static void cook(int index, int totalSour, int totalBitter) {
        if(index == N) {
            if(totalSour + totalBitter != 0) {
                min = Math.min(min, Math.abs(totalSour - totalBitter));
            }
        }
        else {
            cook(index + 1, totalSour, totalBitter);
            if(totalSour != 0) {
                cook(index + 1, totalSour * sour[index], totalBitter + bitter[index]);
            }
            else {
                cook(index + 1, totalSour + sour[index], totalBitter + bitter[index]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        sour = new int[N];
        bitter = new int[N];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        cook(0, 0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
}