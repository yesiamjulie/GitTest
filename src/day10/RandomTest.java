package day10;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {

        //Scanner처럼 생각해주세요.
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {

            // 데이터 vs 정보 : 의미가 있는 데이터가 정보입니다.
            /*
                랜덤에는 종류가 여러가지가 있습니다.
                대표적인 랜덤은 가우시안(정규) 분포,
                이항 분포, 푸아송 분포, 기하 분포 등이 있습니다.
                이 중 자연계를 반영하는 랜덤은 가우시안 분포입니다.

                그리고 특정 사건이 발생 할 확률은 푸아송 분포입니다. ( cctv나 범죄예측, 고장 예측 등에 활용됨 )

                우리가 사용한 랜덤은 균일 랜덤입니다.


             */

            System.out.println("random value = " +
                    rand.nextInt(11));

            /*
                nextInt()에 bound라는 것은 구간을 의미한다.
                0<=random 값 < 11 을 뜻합니다.

                예 : 1~4096 ===> rand.nextInt(4096) + 1
                     0 <= x < 4096
                     1 <= x < 4097

             */

        }
    }
}
