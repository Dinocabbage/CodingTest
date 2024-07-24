import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;

        for(int i : numbers) {
            int[] arr = new int[i];

            if(i != 2 && i % 2 == 0 || i == 1) {
                continue;
            }

            for(int j = 3; j < i; j = j + 2) {
                arr[j] = j;
            }

            boolean isPrime = true;

            for(int k = 3; k < i; k = k + 2) {
                if(arr[k] != 0) {
                    if(i % arr[k] == 0) {
                        isPrime = false;
                        break;
                    }
                    else {
                        for(int l = k; l < i; l += l) {
                            arr[l] = 0;
                        }
                    }
                }
            }

            if(isPrime) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
