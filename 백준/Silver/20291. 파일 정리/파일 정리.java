import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");

            map.put(input[1], map.getOrDefault(input[1], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(String key : map.keySet()) {
            sb.append(key + " " + map.get(key) + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
