package day11;

import java.util.Random;

/*
        배열 100개에 무작위 데이터를 할당한다.
        이 무작위 데이터의 범위는 1~4096(2^12)사이로 할당한다.

        배열 요소 하나가 의미하는 것은 4096 byte에 해당한다.
        이 때, 낭비된 공간의 크기를 산출하시오.
        ( 메모리 관리 정책 알고리즘)
        -------------------------------------해결 ok --------------

        추가적으로 배열 요소 하나의 공간이 4096, 8192, 16384, 32768,    ---- 추가적인 배열 필요( storage[])
        65536, 2^17 까지 가능하다고 가정한다.
        그리고 무작위 데이터는 1~ 2^17 까지 할당할 수 있다.

        이 경우에 이것을 가장 효율적으로 관리하기 위한 프로그램을 작성하시오.
        (Hint. 낭비된 공간이 얼마나 있는지와
        각각의 공간을 효율적으로 쓸 수 있도록 한다.
        비트 연산을 사용하면 효율성이 극대화됨
        추가 문자에 한해 편의상 공간의 개수는 10개로 진행하도록 한다.)



*/


public class QuizAns6 {
    public static void main(String[] args) {

        final int ELEMNUM = 100;
        final int MAXMEM = 4096;
        int lostMem = 0;

        /* 배열 100개에 무작위 데이터를 할당한다*/
        int randData[];
        randData = new int[ELEMNUM];
        int storage[] = {4096, 8192, 16384, 32768, 65536, 131072};

        Random rand = new Random();


        for (; ; ) {

            for (int i = 0; i < ELEMNUM; i++) {

            /*
            이 무작위 데이터의 범위는 1~4096(2^12)사이로 할당한다.
             */
                randData[i] = rand.nextInt(4096) + 1;

//                System.out.println("randData[" + i + "]=" + randData[i]);

                /*
                낭비된 크기 구하기.
                 */
                lostMem += MAXMEM - randData[i];
            }

            /*
                낭비된 크기 산출
             */
            System.out.println("lostMem =" + lostMem);
            lostMem=0;
        }
    }
}

