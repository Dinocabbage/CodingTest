import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(set.contains(num)) {
                set.remove(num);
            }
            else {
                set.add(num);
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(set.contains(num)) {
                set.remove(num);
            }
            else {
                set.add(num);
            }
        }

        bw.write(String.valueOf(set.size()));

        bw.flush();
        bw.close();
        br.close();
    }
}