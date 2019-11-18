package day15;

import java.math.BigInteger;
import java.util.Scanner;

class MyFibSeries {
    private BigInteger series[]; // bigInteger 모든 범위의 수를 표현할 수 있다. 왠만한 수, 돈 계산은 이것으로 ~
    private Scanner in ;
    private Boolean notOk;
    int num;
    BigInteger oddSum, evenSum;

    public MyFibSeries(){

        series = new BigInteger[57];
        in = new Scanner(System.in);

        series[0] = BigInteger.valueOf(1);
        series[1] = BigInteger.valueOf(1);

        notOk = true;
        oddSum = BigInteger.valueOf(0);
        evenSum = BigInteger.valueOf(0);
    }

    public void setSpecificTerm(){


        while (notOk) {
            System.out.println("몇 번째 항까지 작업하시겠어요? ");
            num = in.nextInt();

            if (num < 2) {
                System.out.println("다시 입력해주세요 ~");
            }else {
                notOk =false;
            }

        }
        for (int i = 2; i < num; i++) {

            series[i] = series[i - 2]. add(series[i - 1]);

        }

    }
    public void calcEachSum(){
        for (int i = 0; i < num; i++) {
            if (series[i].mod(BigInteger.valueOf(2)).compareTo(
                    BigInteger.valueOf(1)) == 1){
                oddSum = oddSum.add(series[i]);

            }else {
                evenSum = evenSum.add(series[i]);
            }
        }
    }

    public void calcDiff(){
     //  diff = oddSum.subtract(evenSum);
    }
    public String toString() {
        return "홀수의 합 = " + oddSum +
                "\n짝수의 합 =" + evenSum +
              //  "\n홀수의 합 - 짝수의 합 = " + diff +
                "\n마지막 숫자 =" + series[num - 1];
    }
}

//피보나치 수열
public class ProbBank6 {
    public static void main(String[] args) {

        MyFibSeries mfs = new MyFibSeries();

        mfs.setSpecificTerm();
        mfs.calcEachSum();
        mfs.calcDiff();

        System.out.println(mfs);
    }
}

//종속성이 없으면 clock
//cpu를 만든 intel
//짐켈리가 거쳐간 곳의 업적들 : cpu...

