package day18;

// 문제 10. 랜덤 숫자를 만드시오. ( Q. 랜덤 숫자 범위 ? / 랜덤 숫자 개수)

import java.util.Random;

class RandNum {
    Random rand;
    int random;

    public RandNum() {

        rand = new Random();
    }

    public void initNumber(){
        random = rand.nextInt(6) + 1;
    }

    @Override
    public String toString() {
        return "random Number = " + random;
    }

    /*
    11번 문제를 위해 추가 할 부분

        |
        |
        v

     */
    public int calcAnd(RandNum rn){ // Q. 입력값 RandNum rn?
        return random & rn.random;
    }
    public int calcOr(RandNum rn){

        return random | rn.random;
    }
    public int calcXor(RandNum rn){
        return random ^ rn.random;
    }
    public int calcNot(){
        return ~random;
    }


    /*
     12번 문제를 위해 추가 할 부분

        |
        |
        v

     */

        public int randShift(){
            //true = 왼쪽 , false = 오른쪽
            Boolean leftRight = true;

            //우리가 작성한 random을 shift로 쓰고
            //숫자는 새로운 random을 받도록 한다.
            int newRand;
            Random r = new Random();
            newRand = r.nextInt(65) + 64; //  최소한 64보다는 크게 ( 범위 : 64~ 128)
                                                 //Q. 64 ~ 65
            System.out.println("newRand =" + newRand);

            if (r.nextInt(2) == 1) { // 50% 확률
                leftRight = true;
                System.out.println("left");
            }else {
                leftRight = false;
                System.out.println("right");
            }
            if (leftRight) {
                return newRand << random;
            }else {
                return newRand >> random;
            }
        }


    /*
14번 문제를 위해 추가 할 부분

 |
 |
 v

*/
    public void compareNum(RandNum rn) {
        if (random > rn.random) {
            System.out.println(" 현재 클래스가 더 큽니다.");
        } else if (random < rn.random) {
            System.out.println(" 비교 클래스가 더 큽니다.");

        }else{
            System.out.println(" 두 클래스의 값은 같습니다.");
        }
    }
}
public class Prob10 {
    public static void main(String[] args) {
        RandNum rn = new RandNum();

        for (int i= 0; i < 6 ; i++) {
            rn.initNumber();
            System.out.println(rn);

        }
    }
}
