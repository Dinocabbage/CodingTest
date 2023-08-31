import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
//      0 -> 북, 1 -> 동, 2 -> 남, 3 -> 서

        int[][] room = new int[N][M];

        for(int k = 0; k < N; k++) {
            room[k] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = 0;
        boolean isEnded = false;

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        while(!isEnded) {
            if(room[i][j] == 0) {
                room[i][j] = 2;
                answer++;
            }
            
            if(room[i - 1][j] == 0 || room[i + 1][j] == 0 || room[i][j - 1] == 0 || room[i][j + 1] == 0) {
                while(true) {
                    direction = (direction + 3) % 4;

                    if(room[i + di[direction]][j + dj[direction]] == 0) {
                        i += di[direction];
                        j += dj[direction];
                        break;
                    }
                }
            }
            else {
                if(room[i - di[direction]][j - dj[direction]] == 1) {
                    isEnded = true;
                }
                else {
                    i -= di[direction];
                    j -= dj[direction];
                }
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
