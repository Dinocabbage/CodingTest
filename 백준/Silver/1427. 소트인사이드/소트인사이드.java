import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Arrays.stream(br.readLine().split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining("")));

        bw.flush();
        bw.close();
        br.close();
    }
}