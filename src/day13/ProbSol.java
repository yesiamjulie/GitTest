package day13;

import java.util.Random;

public class ProbSol {
    public static void main(String[] args) {
        final int MAXLEN = 10;
        final int MAXIDX = 6;
        final int START = 4096;

        int stor[][] = null;
        int idxCnt[] = {0, 0, 0, 0, 0, 0};
        stor = new int[MAXIDX][MAXLEN]; // 일일히 배치하기에는 작업이 복잡해지기 때문에

        int freeMem[] = new int[10];
        int freeArea[][] = new int[MAXIDX][MAXLEN];
        int freeIdxCount[] = {0, 0, 0, 0, 0};
        int remain ;

        Random rand = new Random();

        for (int i = 0; i < MAXLEN; i++) {
            // 들어오는 값이 제대로 된 값인지 확인하기 위해 ( 범위내에서 값이 나오고 있는지)
            int tmp = rand.nextInt(131072) + 1; // 1<= x <= 131072

            System.out.println("tmp = " + tmp);


            /*
            현재까지 구현은 공간 할당과 낭비된 공간을 표현한다.
            이 상태에서 추가적으로 처리해야하는 문제는 아래와 같다.
            70000이 입력된 경우 131072를 할당한다.
            남은 공간은 51072가 될 것이다.
            이 경우 32786, 16384를 추가로 분해하여 사용할 수 있다.
            어떻게 표현할 것인가?

            낭비되고 있는 남은 공간은 freeMem이 표현하고 있다.

            1. freeMem &~ 4096... 65536)을 통해서
               분해가 가능한지 여부를 판별해야 한다. o
            2. 3번 작업을 위해 freeIdxCnt[5]도 필요하다. o
            3. freeArea[2의 승수 인덱스][해당 인덱스의 몇 번째]를 저장 // freeArea?
            4. freeMem &~ 32786 ==> res = 32786
               freeMem -res = remain(나머지)  = 51072 - 32768 ( 약 18000)
               remain &~ 16384 ==> res = 16384
               freeMem -res = remain(나머지) = ~18000 - 16384 ( 약 1000)
               if(remain < 4096) 의 조건이면 앞의 작업들을 수행하지 않아도 된다.
            5. 4번을 보면 freeMem을 쓰다가 remain을 쓰고 있다.
               하나로 통일시켜야 for문을 활용할 수 있을텐데
               이 부분을 고려해보도록 한다.
            6. 최종적으로 각 파트별(4096 .....65536)공간이
               몇 개씩 활용이 가능한지 출력하면 된다.
             */
            for(int j=0; j <MAXIDX; j++){
                if (tmp < START << j) {
                    stor[j][idxCnt[j]] = tmp;
                    /*
                    예 : 100000이라는 값이 들어왓을 때 , j가 5가되었을 때가 적절히 배치되는 자리이다 . j[5] = 131072
                         100000< 409
                     */
                    System.out.printf("stor[%d][%d] = %d\n", j , idxCnt[j], stor[j][idxCnt[j]]);

                    freeMem[i] = (START << j ) - tmp;
                    System.out.printf("freeMem[%d] = %d\n\n", i, freeMem[i]);

                    idxCnt[j] ++ ;

                    System.out.println();

                            break;
//                    for(i =0 ; i<MAXIDX ; i++ ) {
//
//                        if( freeMem[i] > 4096 && remain > 4096) {
//                            if ((freeMem[i] & ~(4096 - 1)) > 4096) {
//                                int remain = freeMem[i];
//                                freeMem[i] = freeMem[i] & ~(4096 - 1);
//                                remain -= freeMem[i];
//                                //                    System.out.println(freeMem[i]);
//                                //                    System.out.println("remain = " + remain);
//                                idxCnt[i]++;
//
//                            }
//                        }
//                    }
                }
            }
            // buddy , slab 할당법

            for (int j = 4; j >= 0; j++) {
                remain = freeMem[i];
                if((remain &~ ((START << j) - 1)) >= 4096) {
                    freeArea[j][freeIdxCount[j]] = START << j;
                    freeMem[i] -= START << j;

                }
                System.out.printf("freeMem[%d] = %d\n", i, freeMem[i]);
                System.out.printf("freeArea[%d][%d] = %d\n\n", j, freeIdxCount[j], freeArea[j][freeIdxCount[j]]);

                freeIdxCount[j]++;
            }
        }
    }
}
