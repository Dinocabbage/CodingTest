import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

        IntStream.range(0, m).forEach(i -> {
            try {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                Collections.reverse(list.subList(Integer.parseInt(st2.nextToken()) - 1, Integer.parseInt(st2.nextToken())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.write(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        bw.flush();
        bw.close();
        br.close();
    }
}