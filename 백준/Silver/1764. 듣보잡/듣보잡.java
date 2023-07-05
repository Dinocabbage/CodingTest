import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

//      하나의 배열에 다 받아서 2회 이상 등장하는 원소만 뽑아내는 법
        /*String[] input = new String[N + M];

        for(int i = 0; i < N + M; i++) {
            input[i] = br.readLine();
        }

        List<String> answer = Arrays.stream(input)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .sorted()
                .collect(Collectors.toList());

        sb.append(answer.size() + "\n");
        sb.append(answer.stream().collect(Collectors.joining("\n")));*/

//      두 배열에 나눠 받아서 중복되는 원소만 뽑아내는 법
        String[] input1 = new String[N];

        for(int i = 0; i < N; i++) {
            input1[i] = br.readLine();
        }

        String[] input2 = new String[M];

        for(int i = 0; i < M; i++) {
            input2[i] = br.readLine();
        }

        List<String> answer = Arrays.stream(input1)
                .filter(Arrays.stream(input2).collect(Collectors.toSet())::contains)
                .sorted()
                .collect(Collectors.toList());

        sb.append(answer.size() + "\n");
        sb.append(answer.stream().collect(Collectors.joining("\n")));

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }
}
