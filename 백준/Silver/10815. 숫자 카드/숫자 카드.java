import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int binarySearch(int n, int[] cardNumber, int i) {
        int lt = 0;
        int rt = n - 1;

        while(lt <= rt) {
            int center = (lt + rt) / 2;

            if(cardNumber[center] == i) {
                return 1;
            }
            else if(cardNumber[center] < i) {
                lt = center + 1;
            }
            else {
                rt = center - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cardNumber = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int m = Integer.parseInt(br.readLine());
        int[] findNumber = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();

        for(int i : findNumber) {
            System.out.print(binarySearch(n, cardNumber, i) + " ");
        }
    }

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cardNumber = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] findNumber = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(i, cardNumber[i]);
        }

        for(int i : findNumber) {
            if(map.containsValue(i)) {
                System.out.print(1 + " ");
            }
            else {
                System.out.print(0 + " ");
            }
        }
    }*/
}
