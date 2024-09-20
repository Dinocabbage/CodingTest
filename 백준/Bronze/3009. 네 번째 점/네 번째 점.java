import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] coordX = new int[1001];
        int[] coordY = new int[1001];
        int uniqueX = 0, uniqueY = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x 좌표 처리
            if (coordX[x] == 0) {
                coordX[x] = x;
            } else {
                coordX[x] = 0;
            }

            // y 좌표 처리
            if (coordY[y] == 0) {
                coordY[y] = y;
            } else {
                coordY[y] = 0;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            if (coordX[i] != 0) {
                uniqueX = coordX[i];
            }
            if (coordY[i] != 0) {
                uniqueY = coordY[i];
            }
            if (uniqueX != 0 && uniqueY != 0) {
                break;
            }
        }

        bw.write(uniqueX + " " + uniqueY);

        bw.flush();
        bw.close();
        br.close();
    }
}
