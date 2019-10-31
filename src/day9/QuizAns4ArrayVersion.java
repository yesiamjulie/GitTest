package day9;

import java.util.Scanner;

public class QuizAns4ArrayVersion {
    /*
    숙제 4. 아래와 같은 수열이 존재한다.
            while문을 사용해서 풀어보자.

            1 1 3 4 5 8 12 17 25 37 ... // 3개의 항을 보아야 함

    키보드 입력을 받아 몇 번째 항까지
    합치기(sigma)를 수행할지 정한다.

    합치기 결과를 출력하시오.

     */
    public static void main(String[] args) {

        //실제 [new]개수만큼 int형 배열을 할당( 메모리 할당 )
        int[] series;

        Scanner in = new Scanner(System.in);
        System.out.println("몇 번째 항까지 합치기할까요? :");
        int num = in.nextInt();


        series = new int[num];

        int res= 0;

        // 메모리가 할당되었으므로 실제 데이터를 배치
        series[0] = 1; series[1] = 1; series[2] = 3;

        /* 배열의 인덱스는 0부터 시작한다는 것 !
           그러므로 1번째는 [0] , 2번째는 [1], 3번째는 [2] .......임을 기억하자.*/

        for (int i = 3; i < num; i++) {
            series[i] = series[i-3] + series[i-1];
        }
        for (int i = 0; i < num; i++) {
            System.out.println("series[" + i + "] =" + series[i]);

        }

        for (int i = 0; i < num; i++) {

          res += series[i];

        }
        System.out.println("final result = " + res);

    }

        /* 숙제5.
           1 2 4 8 16 32 64 128 256 512 1024 2048 4096 ....

           위 수열의 데이터를 각각 배열에 저장한다.
           인덱스는 0부터 시작한다.

           8번째, 10번째, 12번째, 16번째 인덱스의 값들을 추출하여 출력하고
           추출한 값들을 모두 더한 값을 출력하시오.

         */
}
