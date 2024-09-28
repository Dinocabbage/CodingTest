import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> strings = new HashMap<>();

        for(int i = 0; i < N; i++) {
            strings.put(br.readLine(), 1);
        }

        int answer = 0;

        for(int i = 0; i < M; i++) {
            String check = br.readLine();

            if(strings.containsKey(check)) {
                answer += strings.get(check);
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}