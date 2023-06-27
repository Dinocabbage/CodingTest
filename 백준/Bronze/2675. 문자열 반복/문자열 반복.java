import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        IntStream.range(0, Integer.parseInt(br.readLine())).forEach(i -> {
            StringTokenizer st;
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int n = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            IntStream.range(0, word.length()).forEach(j -> {
                IntStream.range(0, n).forEach(k -> {
                    try {
                        bw.write(String.valueOf(word.charAt(j)));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
            try {
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
        bw.close();
        br.close();
    }
}