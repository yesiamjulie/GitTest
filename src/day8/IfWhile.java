package day8;

public class IfWhile {
    /*
        1~5까지의 숫자 중 짝수만 찾아서
        1~9까지 곱하고, 각각의 결과를 출력해보자.

     */
    public static void main(String[] args) {
        int i, j = 1;

        for (i=1; i< 6; i++) {
            System.out.println("i  Loop");
            if (i % 2 == 0) {
                System.out.println("Condition Success");
                /*
                j의 초기화 부분이 없었을 때
                j가 1로 다시 초기화되지 않고 10인 상태를 유지하여 출력이 되지 않음
                 */
                System.out.println("j =" + j);
                for (j=1; j< 10; j++ ) {
                    System.out.println("res = " + i + "*" + j + (i * j));
                }
            }
        }


    }
}
