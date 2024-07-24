import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        if(M <= 2 && N >= 2) {
            arr[2] = 2;
        }

        for(int i = 3; i <= N; i += 2) {
            arr[i] = i;
        }

        for(int i = 3; i * i <= N; i += 2) {
            if(arr[i] != 0) {
                for(int j = i * i; j <= N; j += i) {
                    arr[j] = 0;
                }
            }
        }

        int[] primeArr = Arrays.stream(arr, M, N + 1).filter(i -> i != 0).toArray();

        int sum = Arrays.stream(primeArr).sum();

        if(sum != 0) {
            bw.write(String.valueOf(sum));
            bw.newLine();
            OptionalInt smallest = IntStream.of(primeArr).min();

            bw.write(String.valueOf(smallest.getAsInt()));
        }
        else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
