import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] wifi = new int[N];

        for(int i = 0; i < N; i++) {
            wifi[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wifi);

        int lt = 1;
        int rt = Arrays.stream(wifi).max().getAsInt();

        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int tmp = wifi[0];
            int wifiCount = 1;
            for(int i : wifi) {
                if(i - tmp >= mid) {
                    tmp = i;
                    wifiCount++;
                }
            }

            if(wifiCount < C) {
                rt = mid - 1;
            }
            else {
                answer = mid;
                lt = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();

        bw.close();
        br.close();
    }
}
