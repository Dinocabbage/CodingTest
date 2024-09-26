import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).toArray()[k - 1]));

        bw.flush();
        bw.close();
        br.close();
    }
}