package day18;
//    문제 13. 2,4,6,8,10..............120.... 100번째 까지 더한 숫자를 출력하시오.

/*
이 문제에서 사용된 개념
0. 클래스 작성법
1. 배열 사용법
2. 제어문 중 for문 활용법

 */

// 등차수열 : ArithSequence
class ArithSequence{
    int series[];
    int first;
    int num;

    public ArithSequence(int first, int num) { // 초항과 배열크기를 입력 받는다.

        series = new int[num];
        series[0] = first;
        this.num = num;
        this.first = first;
    }


    public void calcArithSeq(){
        for (int i = 1; i < num; i++) {
            series[i] = series[i - 1] + first;
        }
    }
    @Override
    public String toString() {
        return "series[" + (num -1) + "] ="  +
                series[num -1];
    }
}

public class Prob13 {
    public static void main(String[] args) {
        // Q. 100번째 결과값?, 100번까지 더한 결과
        ArithSequence ar = new ArithSequence(2, 4);
        ar.calcArithSeq();
        System.out.println(ar);
    }
}
