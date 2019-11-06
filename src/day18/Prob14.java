package day18;
//    문제 14. 랜덤한 숫자를 2 개 입력받고
//            대소 비교를 하세요 ~

/*
    이 문제에서 사용된 개념
        0. 클래스 작서업
        1. if, else, else if 사용법
 */
public class Prob14 {
    public static void main(String[] args) {
        RandNum rn1 = new RandNum();
        RandNum rn2 = new RandNum();

        rn1.initNumber();
        rn2.initNumber();

        System.out.println(rn1);
        System.out.println(rn2);


        rn1.compareNum(rn2);
    }
}
