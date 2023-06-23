import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static String parseAlphabetNumber(int num) {
        String answer = "";
        String[] alphabetNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        if(num / 10 != 0) {
            answer += alphabetNumber[num / 10] + " ";
        }

        answer += alphabetNumber[num % 10];

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minNum = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());

        br.close();

        HashMap<String, Integer> map = new HashMap<>();
        String[] alphabetNums = new String[maxNum - minNum + 1];
        int index = 0;

        for(int i = minNum; i <= maxNum; i++) {
            String alphaNum = parseAlphabetNumber(i);
            alphabetNums[index++] = alphaNum;
            map.put(alphaNum, i);
        }

        Arrays.sort(alphabetNums);

        index = 0;
        for(String s : alphabetNums) {
            System.out.print(map.get(s) + " ");
            index++;

            if(index == 10) {
                System.out.println();
                index = 0;
            }
        }
    }
}
