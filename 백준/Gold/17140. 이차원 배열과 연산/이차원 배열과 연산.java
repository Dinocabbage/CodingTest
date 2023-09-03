import java.io.*;
import java.util.*;

class Element {
    private int number;
    private int count;

    Element(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public int getNumber() {
        return this.number;
    }

    public int getCount() {
        return this.count;
    }
}

public class Main {
    static int[][] A;
    static int rowLen, colLen;
    public static void operateR() {
        int maxLength = 0;

        for(int i = 1; i <= rowLen; i++) {
            int[] count = new int[101];
            List<Element> elements = new ArrayList<>();

            for(int j = 1; j <= colLen; j++) {
                if(A[i][j] != 0) {
                    count[A[i][j]]++;
                }
            }

            for(int j = 1; j <= 100; j++) {
                if(count[j] > 0) {
                    elements.add(new Element(j, count[j]));
                }
            }

            Collections.sort(elements, Comparator.comparing(Element::getCount).thenComparing(Element::getNumber));

            int length = elements.size() * 2;
            maxLength = Math.max(maxLength, length);

            for(int j = 1; j <= 50; j++) {
                if(j <= elements.size()) {
                    A[i][j * 2 - 1] = elements.get(j - 1).getNumber();
                    A[i][j * 2] = elements.get(j - 1).getCount();
                }
                else {
                    A[i][j * 2 - 1] = 0;
                    A[i][j * 2] = 0;
                }
            }
        }

        colLen = maxLength;
    }
    public static void operateC() {
        int maxLength = 0;

        for(int j = 1; j <= colLen; j++) {
            int[] count = new int[101];
            List<Element> elements = new ArrayList<>();

            for(int i = 1; i <= rowLen; i++) {
                if(A[i][j] != 0) {
                    count[A[i][j]]++;
                }
            }

            for(int i = 1; i <= 100; i++) {
                if(count[i] > 0) {
                    elements.add(new Element(i, count[i]));
                }
            }

            Collections.sort(elements, Comparator.comparing(Element::getCount).thenComparing(Element::getNumber));

            int length = elements.size() * 2;
            maxLength = Math.max(maxLength, length);

            for(int i = 1; i <= 50; i++) {
                if(i <= elements.size()) {
                    A[i * 2 - 1][j] = elements.get(i - 1).getNumber();
                    A[i * 2][j] = elements.get(i - 1).getCount();
                }
                else {
                    A[i * 2 - 1][j] = 0;
                    A[i * 2][j] = 0;
                }
            }
        }

        rowLen = maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        A = new int[101][101];

        for(int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rowLen = 3;
        colLen = 3;

        int second = 0;

        while(second <= 100) {
            if(A[r][c] == k) {
                break;
            }

            if(rowLen >= colLen) {
                operateR();
            }
            else {
                operateC();
            }

            second++;
        }

        if(A[r][c] == k) {
            bw.write(String.valueOf(second));
        }
        else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
