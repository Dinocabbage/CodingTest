import java.io.*;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Main {
    private static char c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> dial = new HashMap<>();
        c = 'A';

        IntStream.rangeClosed(3, 10).forEach(i -> {
            int count = (i == 8 || i == 10) ? 4 : 3;
            IntStream.range(0, count).forEach(j -> {
                dial.put(c++, i);
            });
        });

        bw.write(String.valueOf(br.readLine().chars().mapToObj(n -> (char) n).mapToInt(dial::get).sum()));

        bw.flush();
        bw.close();
        br.close();
    }
}