import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int sum = 0;

        while(sum < N) {
            count++;
            sum += count;
        }
        
        int diff = sum - N;

        bw.write(count % 2 == 0 ? (count - diff) + "/" + (1 + diff) : (1 + diff) + "/" + (count - diff));

        bw.flush();
        bw.close();
        br.close();
    }
}