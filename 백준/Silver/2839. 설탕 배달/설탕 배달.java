import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int fiveCount = 0;
        int threeCount = 0;
        int sum = 0;

        int answer;

        while(sum < N) {
            sum += 5;
            fiveCount++;
        }

        if(sum == N) {
            answer = fiveCount;
        }
        else {
            while(true) {
                if(sum == N) {
                    answer = fiveCount + threeCount;
                    break;
                }
                else if(sum < N) {
                    sum += 3;
                    threeCount++;
                }
                else {
                    sum -= 5;
                    fiveCount--;

                    if(fiveCount == -1) {
                        answer = -1;
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}