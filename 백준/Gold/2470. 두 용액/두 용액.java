import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int lt = 0;
        int rt = N - 1;
        int solution1 = 0, solution2 = 0;
        int closeToZero = Integer.MAX_VALUE;

        while(lt < rt) {
            int mix = solutions[lt] + solutions[rt];

            if(Math.abs(mix) < closeToZero) {
                closeToZero = Math.abs(mix);
                solution1 = solutions[lt];
                solution2 = solutions[rt];
            }

            if(mix == 0) {
                break;
            }
            else if(mix < 0 && solutions[lt] < 0) {
                lt++;
            }
            else if(mix > 0 && solutions[rt] > 0){
                rt--;
            }
        }

        bw.write(solution1 + " " + solution2);

        bw.flush();

        bw.close();
        br.close();
    }
}
