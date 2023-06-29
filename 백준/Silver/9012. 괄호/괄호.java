import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            Stack<Character> s = new Stack<>();
            
            for(char c : br.readLine().toCharArray()) {
                if(c == '(') {
                    s.push(c);
                }
                else {
                    if(!s.empty()) {
                        s.pop();
                    }
                    else {
                        s.push(' ');
                        break;
                    }
                }
            }

            if(s.empty()) {
                bw.write("YES");
                bw.newLine();
            }
            else {
                bw.write("NO");
                bw.newLine();
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}