package day18;
// 문제 11 . 랜덤 숫자 2개를 작성하고, 이들간의 and, or, xor, not을 계산하시오
/*
 4가지 연산을 클래스로 정의해두고 결과를 받아온다.

 이 문제에서 쓰인 개념
 0. 클래스 작성법
 1. 기존에 작성한 클래스를 활용하는 방법
 2. and, or, xor, not 등의 비트 연산자 학습
 */

public class Prob11 {
    public static void main(String[] args) {

        RandNum rn1 = new RandNum();
        RandNum rn2 = new RandNum();

        rn1.initNumber();
        rn2.initNumber();


        System.out.println("rn1 :" + rn1);
        System.out.println("rn2 :" + rn2);
        System.out.println("and : " + rn1.calcAnd(rn2) );
        System.out.println("or : " +  rn1.calcOr(rn2));
        System.out.println("not rn1: " + rn1.calcNot());
        System.out.println("not rn2: " + rn2.calcNot());
        System.out.println("xor : " + rn1.calcXor(rn2));

    }
}
