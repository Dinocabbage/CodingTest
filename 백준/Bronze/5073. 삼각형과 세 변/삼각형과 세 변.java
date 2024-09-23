import java.io.*;
import java.util.Arrays;

public class Main {
    private static String kindOfTriangle(int[] lines) {
        String answer;

        Arrays.sort(lines);

        if(lines[2] >= lines[0] + lines[1]) {
            answer = "Invalid";
        }
        else {
            if(lines[0] == lines[1] && lines[0] == lines[2]) {
                answer = "Equilateral";
            }
            else if(lines[0] == lines[1] || lines[0] == lines[2] || lines[1] == lines[2]) {
                answer = "Isosceles";
            }
            else {
                answer = "Scalene";
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(input[0] == 0) {
                break;
            }
            else {
                bw.write(kindOfTriangle(input));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}