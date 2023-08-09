import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int lt = 0;
        int answer = Integer.MAX_VALUE;

        while(lt < N) {
            for(int rt = lt + 1; rt < N; rt++) {
                if(A[rt] - A[lt] >= M) {
                    answer = Math.min(answer, A[rt] - A[lt]);
                    break;
                }
            }
            
            if(answer == M) {
                break;
            }

            lt++;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}