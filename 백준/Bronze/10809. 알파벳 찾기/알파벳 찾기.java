import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        IntStream.range(0, s.length()).forEach(i -> {
            int index = s.charAt(i) - 'a';
            if(arr[index] == -1) {
                arr[index] = i;
            }
        });

        bw.write(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        bw.flush();
        bw.close();
        br.close();
    }
}