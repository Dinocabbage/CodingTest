import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> keyName = new HashMap<>();
        Map<Integer, String> keyNumber = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            keyName.put(name, i);
            keyNumber.put(i, name);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            try {
                int parsingInput = Integer.parseInt(input);

                sb.append(keyNumber.get(parsingInput)).append("\n");
            }
            catch(NumberFormatException e) {
                sb.append(keyName.get(input)).append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}