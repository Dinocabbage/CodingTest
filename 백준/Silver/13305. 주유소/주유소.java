import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] roadLength = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] gasStation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long answer = 0;
        long length = 0;
        long cheapest = gasStation[0];

        for(int i = 0; i < N - 1; i++) {
            if(gasStation[i] < cheapest) {
                answer += cheapest * length;
                cheapest = gasStation[i];
                length = 0;
            }

            length += roadLength[i];
        }

        answer += cheapest * length;

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}