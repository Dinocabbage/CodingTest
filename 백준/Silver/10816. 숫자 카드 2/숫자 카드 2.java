import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(map.containsKey(card)) {
                map.put(card, map.get(card) + 1);

            }
            else {
                map.put(card, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)) {
                bw.write(map.get(num) + " ");
            }
            else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}