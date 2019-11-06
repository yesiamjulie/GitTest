package day18;
// 문제 12. 랜덤 숫자를 만들고 랜덤한 쉬프트 연산을 해보세요.

/*
이 문제에서 사용된 개념
0. 클래스 작성법
1. 비트 연산자 shift(<< ,  >> ) 복습
2. Boolean 타입 복습 ( true, false를 저장할 수 있음)
3. '%' 연산자(mod) 활용범     // Q. 어디에 쓰였나
4. 제어문 중 if문 활요업
 */

public class Prob12 {
    public static void main(String[] args) {

        RandNum rn = new RandNum();
        rn.initNumber();

        System.out.println(rn);

        System.out.println("random shift :"  + rn.randShift());
    }
}
