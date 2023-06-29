import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stk = new Stack<>();
        StringBuilder process = new StringBuilder();
        int index = 0;

        for(int i = 1; i <= n; i++) {
            stk.push(i);
            process.append("+\n");

            while(!stk.empty()) {
                int a = stk.pop();

                if(a == arr[index]) {
                    process.append("-\n");
                    index++;
                }
                else {
                    stk.push(a);
                    break;
                }
            }
        }
        if(!stk.empty()) {
            bw.write("NO");
        }
        else {
            bw.write(process.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}