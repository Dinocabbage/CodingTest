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

        int numerator = 0;
        int denominator = 0;

        if(count % 2 == 0) {
            numerator = count;
            denominator = 1;

            while(sum > N) {
                numerator--;
                denominator++;
                sum--;
            }
        }
        else {
            numerator = 1;
            denominator = count;

            while(sum > N) {
                numerator++;
                denominator--;
                sum--;
            }
        }

        bw.write(numerator + "/" + denominator);

        bw.flush();
        bw.close();
        br.close();
    }
}