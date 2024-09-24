import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int seriesNum = 666;
        int seriesCnt = 1;

        while(true) {
            if(seriesCnt == N) {
                break;
            }

            seriesNum++;

            if(String.valueOf(seriesNum).contains("666")) {
                seriesCnt++;
            }
        }

        bw.write(String.valueOf(seriesNum));

        bw.flush();
        bw.close();
        br.close();
    }
}