package day14;


public class Homework8 {
    public static void main(String[] args) {


        int num1 = 1;
        int num2 = 3;

        int[] array1 = new int[23];
        long[] array2 = new long[56];
        int odd_sum = 0;
        int even_sum = 0;


        for (int i = 0; i < array1.length; i++) {
            if (i == 0) {
                array1[i] = num1;

            }
            if (i == 1) {
                array1[i] = num2;
            }

            if (i > 1) {
                array1[i] = array1[i - 1] + array1[i - 2];
            }
//            System.out.println("array[" + i + "]=" + array1[i]);
        }
        System.out.println("----------문제은행 5번----------");
        System.out.println("23번째 숫자는 " + array1[22] + "입니다.");
        System.out.println();

        for (int i = 0; i < array2.length; i++) {
            if (i == 0 || i == 1) {

                array2[i] = num1;

            } else if (i > 1) {

                array2[i] = array2[i-1] + array2[i-2];

            }

            if( array2[i] % 2 == 1){

                odd_sum += array2[i];

            } else if (array2[i] % 2 == 0) {

                even_sum += array2[i];
            }


        }
            long diff = odd_sum - even_sum;
        System.out.println("----------문제은행6번----------");
        System.out.println("홀수들의 합 :" + odd_sum );
        System.out.println("짝수들의 합 :" + even_sum);
        System.out.println("홀수들의 합 - 짝수들의 합 :" + diff);
        System.out.println();
    }

}
