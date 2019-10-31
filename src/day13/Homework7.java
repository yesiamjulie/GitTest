package day13;

import org.w3c.dom.ranges.Range;

import java.util.Random;
import java.util.Scanner;

/*
7-1 ) -137 을 비트로 표현하시오.

-137 = -X
137  = X
+137= 0 10001001
-137= 1 01110111 = -X

따라서, 답은 101110111(2)
답이 맞는지 역산해보면 137을 구하면 된다.
010001001


7-2) 10001010 11111010을 16진수로 표현하시오.
16자리이므로 16진수?
16진법으로 계산 : 08 a f a
                16^3 * 8 + 16^2 * 10 + 16* 15 + 10

2진수로 계산 : 1000 1010 1111 1010 으로 끊어서 계산
              15   11   7    3
               2^16  + 2^15 + 2^11 + 2^7 + 2^3

 */

public class Homework7 {

//    숙제 7- 3.  랜덤 숫자를 입력받아서
//                1024 단위로 정렬하도록 프로그래밍 하시오.


    static class AlignTest{
        //랜덤 숫자를 입력 받자. -> 랜덤한 숫자 7개를 자동으로 입력 받자.
        int arr[];
        Random rand;
        final int RANGE = 1024;


        void initArr(){
            arr = new int[7];
            rand = new Random();

            for (int i = 0; i < 7; i++) {
                arr[i] = rand.nextInt(7777) + 1;
            }
        }

        //이제 정렬하자. 1024 단위로 정렬하기.
        void alignArr(){
            for (int i = 0; i < 7; i++) {

                arr[i] &= -(RANGE -1); // 2의 승수에 한해서 &~ 기법이 적용될 수 있다.

                /* 또는
                arr[i] = arr[i] & ~(RANGE -1);

                 */
            }
        }

        void printArr(){
            for (int i = 0; i < 7; i++) {
                System.out.printf("arr[%d] = %d\n" , i , arr[i]);
            }
        }
    }
    public static void main(String[] args) {

        AlignTest at = new AlignTest();
        at.initArr();
        at.printArr();
        at.alignArr();
        at.printArr();
    }
}
