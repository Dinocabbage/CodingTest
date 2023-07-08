import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.stream().sorted(Comparator.comparing(String::length).thenComparing(s -> s)).distinct().map(String::valueOf).collect(Collectors.joining("\n")));

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}