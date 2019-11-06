package day18;
// 문제 9. 8번 문제를 키보드 입력으로 처리해주세요.

// 8번에서 만들었던 클래스를 쓰면 되지만, 필요한 부분이 Scanner !

/*
이 문제에서 알아야 할 개념
0. 클래스 작성법
1. Scanner 사용법
2. 상속(extends) 사용법
 */

import java.util.Scanner;

class Scan extends Numbers{

    private Scanner input;


    public Scan() {

        super();
        input = new Scanner(System.in);

    }




    public void keyboardIn(){
        System.out.println("첫 번째 정수를 입력하세요 ~");
        setOne(input.nextInt());

        System.out.println("두 번째 정수를 입력하세요 ~");
        setTwo(input.nextInt());

        System.out.println("float형의 숫자를 입력하세요 ~");
        setfOne(input.nextFloat());

        System.out.println("double형의 숫자를 입력하세요 ~");
        setdOne(input.nextDouble());

    }

}


public class Prob9 {
    public static void main(String[] args) {
        Scan s = new Scan();
        s.keyboardIn();
        System.out.println(s);
    }
}
