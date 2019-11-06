package day17;

import java.util.Random;
import java.util.Scanner;

class Num {
    int num1, num2;
    int i, j = 0;
    float num3;
    double num4;

    //    long rand;
    Scanner input1, input2, input3, input4;

}

class NumTest extends Num {


    public NumTest(int a, int b, float c, double d) {

        num1 = a;
        num2 = b;
        num3 = c;
        num4 = d;
    }

}


//        문제 10. 랜덤 숫자를 만드시오

//   문제 11. 랜덤 숫자 2 개를 작성하고
//           이들간의 and, or, xor, not 을 계산하시오.
class RandomNum extends Num {
    Random rand1 = new Random();
    Random rand2 = new Random();

    public RandomNum() {

        for (i = 0; i < 2; i++) {

            System.out.println("랜덤 숫자" + i + ":" +  rand1.nextInt(11));
            System.out.println("랜덤 숫자" + i + ":" +  rand2.nextInt(11));


        }

    System.out.println("not :"   );

    }
}


public class Exam8 {
    /*
    문제 8. 정수형 변수 2개, 4 byte형 소수점 변수 1개, 8 byte형 소수점 변수 1개를 만들고 출력하시오.
    문제 9. 8번 문제를 키보드 입력으로 처리해주세요. -----
    문제 10. 랜덤 숫자를 만드시오. ( Q. 랜덤 숫자 범위는 임의?)
    문제 11 . 랜덤 숫자 2개를 작성하고, 이들간의 and, or, xor, not을 계산하시오
    문제 12. 랜덤 숫자를 만들고 랜덤한 쉬프트 연산을 해보세요.
    문제 13. 2,4,6,8,10..............120.... 100번째 까지 더한 숫자를 출력하시오.
    문제 14. 랜덤한 숫자를 2 개 입력받고
            대소 비교를 하세요 ~

   문제 15. 2 by 2 행렬의 뺄셈을 작성하세요 ~

   문제 16. Bank 클래스를 작성하시오.

   문제 17. 성적 관리 프로그램을 만들어보세요 ~

   문제 18. abstract 클래스와
            interface 의 차이점을 기술해보세요 ~


     */
    public static void main(String[] args) {
//        int num1, num2;
////        float num3;
////        double num4;

        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);

//        System.out.println("정수 2개를 입력하세요 : ");
//        System.out.println("소수점 변수 2개를 입력하세요 : ");


    }
}
