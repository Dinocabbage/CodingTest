import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int answer = 0;

            while(!queue.isEmpty()) {
                int[] arr = queue.poll(); // 검사할 배열
                boolean isHighest = true; // 가장 높은 위험도인지 판별
                for(int i = 0; i < queue.size(); i++) { // 검사할 배열을 제외하고 한바퀴 돌면서 검사
                    int[] tmp = queue.poll();
                    if(arr[1] < tmp[1]) { // 검사할 배열보다 위험도가 높으면 isHighest = false
                        isHighest = false;
                    }
                    queue.offer(tmp); // 확인 후 뒤에 삽입
                }

                if(!isHighest) {    // 위험도가 가장 높지 않으면 뒤에 다시 넣기
                    queue.offer(arr);
                }
                else {
                    answer++;   // 위험도가 가장 높으면 answer++
                    if(arr[0] == M) { // index가 M이면 break
                        break;
                    }
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
