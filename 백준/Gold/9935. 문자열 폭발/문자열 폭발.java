import java.io.*;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static String solution(String str, String bomb) {
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            stack.push(c);

            if(stack.size() >= bombLen) {
                boolean isBomb = true;

                for(int i = 0; i < bombLen; i++) {
                    if(stack.get(stack.size() - bombLen + i) != bomb.charAt(i)) {
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb) {
                    for(int i = 0; i < bombLen; i++) {
                        stack.pop();
                    }
                }
            }
        }

        return stack.empty() ? "FRULA" : stack.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        bw.write(solution(str, bomb));

        bw.flush();
        bw.close();
        br.close();
    }
}