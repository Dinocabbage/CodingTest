import java.io.*;
import java.util.ArrayList;
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

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.rangeClosed(1, n).forEach(index -> list.add(index));

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int tmp = list.get(j - 1);
            list.set(j - 1, list.get(k - 1));
            list.set(k - 1, tmp);
        }
        bw.write(list.stream().map(Object::toString).collect(Collectors.joining(" ")));

        bw.flush();
        br.close();
        bw.close();

    }
}