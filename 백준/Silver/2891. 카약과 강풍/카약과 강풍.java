import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        TreeSet<Integer> destroyed = new TreeSet<>();
        TreeSet<Integer> spare = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < S; i++) {
            int n = Integer.parseInt(st.nextToken());

            destroyed.add(n);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < R; i++) {
            int n = Integer.parseInt(st.nextToken());

            spare.add(n);
        }

        for(int i : destroyed.stream().mapToInt(Integer::intValue).toArray()) {
            if(spare.contains(i)) {
                destroyed.remove(i);
                spare.remove(i);
            }
            else if(spare.contains(i - 1) && !destroyed.contains(i - 1)) {
                destroyed.remove(i);
                spare.remove(i - 1);
            }
            else if(spare.contains(i + 1) && !destroyed.contains(i + 1)) {
                destroyed.remove(i);
                spare.remove(i + 1);
            }
        }

        bw.write(String.valueOf(destroyed.size()));

        bw.flush();
        bw.close();
        br.close();
    }
}
