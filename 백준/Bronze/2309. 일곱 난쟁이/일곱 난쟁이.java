import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] input = new int [9];

        // 입력 값을 int 배열로 받음
        for(int i = 0; i < 9; i++) {
            input[i] = sc.nextInt();
        }

        // 미리 정렬
        Arrays.sort(input);

        // 제외할 난쟁이 변수로 초기화
        int del1 = 0;
        int del2 = 8;

        // 키의 총 합을 저장할 변수
        int total = 0;

        // 키의 총합이 100이 될 때까지 반복
        while(true) {
            total = 0;
            // del1과 del2를 제외한 index 모두 더하기
            for(int i = 0; i < 9; i++) {
                if(i != del1 && i != del2) {
                    total += input[i];
                }
            }

            if(total == 100) {
                break;
            }

            del1++;

            // del1과 del2가 같아지면 다시 초기화
            if(del1 == del2) {
                del1 = 0;
                del2--;
            }
        }

        // 출력
        for(int i = 0; i < 9; i++) {
            if(i != del1 && i != del2){
                System.out.println(input[i]);
            }
        }

    }
}
