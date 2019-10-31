package day12;

public class QuizClass {

    /*
    문제 6. class를 활용하여
     2 by 2 행렬의 덧셈을 구현하시오.
    */

    class matrix {

        int res;
        void plus(int i, int j ){
            res = i + j;
        }


    }
    public static void main(String[] args) {

        int arr[][] = new int[2][2];
        int idx = 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < idx; j++) {
                arr[i][j] = i*2 + j +1 ;

                System.out.printf("%d ", arr[i][j]);
            }
            idx --;
            System.out.println();
        }

    }
}
