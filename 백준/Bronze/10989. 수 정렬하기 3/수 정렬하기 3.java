import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[10001];

        for(int i = 0; i < N; i++) {
            numbers[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 10001; i++) {
            if(numbers[i] > 0) {
                for(int j = 0; j < numbers[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}