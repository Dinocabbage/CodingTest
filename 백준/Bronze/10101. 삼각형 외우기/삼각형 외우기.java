import java.io.*;

public class Main {
    private static String kindOfTriangle(int A, int B, int C) {
        String answer;

        if(A + B + C == 180) {
            if(A == B && A == C) {
                answer = "Equilateral";
            }
            else if (A != B && A != C && B != C) {
                answer = "Scalene";
            }
            else {
                answer = "Isosceles";
            }
        }
        else {
            answer = "Error";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());

        int B = Integer.parseInt(br.readLine());

        int C = Integer.parseInt(br.readLine());

        bw.write(kindOfTriangle(A, B, C));

        bw.flush();
        bw.close();
        br.close();
    }
}
