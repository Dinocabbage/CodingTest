import java.io.*;
import java.util.*;

public class Main {
    public static int find(int v, int[] unf) {
        if(v == unf[v]) {
            return v;
        }
        else {
            unf[v] = find(unf[v], unf);
            return unf[v];
        }
    }
    public static void union(int a, int b, int[] unf) {
        int fa = find(a, unf);
        int fb = find(b, unf);

        if(fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] unf = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0) {
                union(b, c, unf);
            }
            else {
                int fb = find(b, unf);
                int fc = find(c, unf);

                if(fb == fc) {
                    bw.write("YES");
                }
                else {
                    bw.write("NO");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
