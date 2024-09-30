import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(name, String.valueOf(i));
            map.put(String.valueOf(i), name);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}