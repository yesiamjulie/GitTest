package day7;

import java.util.Scanner;

public class WhileTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("몇 번 반복할까요? :");
        int num = in.nextInt();
        int i = 1;

        /*
            while은 말 그대로
            '~ 을 하는 동안'을 그대로 보여주는 구문이다.

            --- while문을 사용하는 방법
            1. 일단 반복이 필요한 부분에 while()을 적는다.

            2. 조건을 괄호 안에 적는다.

            3. block안에 조건이 만족된 경우
               동작 할 반복 패턴을 작성한다.

         */

        /*
            전위연산자와 후위연산자

            전위연산자의 경우 먼저 계산을 하게 된다.
            ( 그 어떤 무엇보다 계산이 먼저 진행)

            후위연산자의 경우 계산은 나중에 적용된다.
            나중이란 의미는 다음 줄을 진행하기 전에 진행된다.

            아래의 경우 전위연산자일 경우 , 입력받은 값보다 한번 작게
            후위연산자의 경우, 입력받은 값만큼 반복되어 출력된다.
         */
        while (--num > 0) {

            System.out.println("반복");

        }


        /*
            문제1. while문을 사용해서
            1~100까지 숫자 중 3의 배수를 추출하시오.
            (for 문 사용 금지)

            숙제 4. 아래와 같은 수열이 존재한다.

            1 1 3 4 5 8 12 17 25 37 ...

            키보드 입력을 받아 몇 번째 항까지
            합치기(sigma)를 수행할지 정한다.

            합치기 결과를 출력하시오.

         */

        while( i < 100) {

            i++;
            if (i % 3 == 0) {

                System.out.println("3의 배수 : " + i);
            }
        }
    }
}
