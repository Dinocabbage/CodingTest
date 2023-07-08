import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    private static int N;
    private static long max, min;
    private static char[] inequalitys;

    public static void solution(int[] numbers, int index) {
        if(index == N + 1) {
            long number = Long.parseLong(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining("")));
            if(number > max) {
                max = number;
            }
            if(number < min) {
                min = number;
            }
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(isPlaceable(numbers, i, index)) {
                numbers[index] = i;
                solution(numbers, index + 1);
                numbers[index] = -1;
            }
        }
    }

    public static boolean isPlaceable(int[] numbers, int i, int index) {
        int lastNum = -1;

        if(index == 0) {
            return true;
        }

        for(int j : numbers) {
            if(j == -1) {
                break;
            }
            else if(j == i) {
                return false;
            }
            lastNum = j;
        }

        if(lastNum == -1) {
            return true;
        }

        if(inequalitys[index - 1] == '<' && lastNum > i) {
            return false;
        }
        else if(inequalitys[index - 1] == '>' && lastNum < i) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        inequalitys = br.readLine().replaceAll(" ", "").toCharArray();

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        int[] numbers = new int[N + 1];
        Arrays.fill(numbers, -1);

        solution(numbers, 0);

        if(String.valueOf(max).length() != N + 1) {
            bw.write("0" + max);
            bw.newLine();
        }
        else {
            bw.write(String.valueOf(max));
            bw.newLine();
        }

        if(String.valueOf(min).length() != N + 1) {
            bw.write("0" + min);
        }
        else {
            bw.write(String.valueOf(min));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}