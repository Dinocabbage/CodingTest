import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dy = new int[N];
        int[] lastIndex = new int[N];

        Arrays.fill(dy, 1);

        int maxLength = 0;
        int last = -1;

        for (int i = 0; i < N; i++) {
            dy[i] = 1;
            lastIndex[i] = -1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dy[i] < dy[j] + 1) {
                    dy[i] = dy[j] + 1;
                    lastIndex[i] = j;
                }
            }
            if (dy[i] > maxLength) {
                maxLength = dy[i];
                last = i;
            }
        }

        int[] longest = new int[maxLength];
        bw.write(maxLength + "\n");

        while (last != -1) {
            longest[--maxLength] = A[last];
            last = lastIndex[last];
        }

        bw.write(Arrays.stream(longest).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        bw.flush();
        bw.close();
        br.close();
    }
}
