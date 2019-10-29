import java.util.Random;



    class Matrix {
        int A[][];
        int B[][];
        int res[][];
        Random rand;

        void initArr() { // 메소드 : 기능  -> 배열 메모리 할당, 출력 / 이름/ 입력
            A = new int[2][2];
            B = new int[2][2];
            res = new int[2][2];
            rand = new Random();

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    A[i][j] = rand.nextInt(5) + 1; // 1부터 5까지의 무작위 수로 배정
                    B[i][j] = rand.nextInt(5) + 1;

                }
            }
        }

        void addMatrix() { // 이 메소드를 호출하면 아래와 같이 진행한다.
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    res[i][j] = A[i][j] + B[i][j];
                }
            }
        }

        void printArr() { // 각각의 값들을 출력하는 기능
            System.out.println("res =");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {

                    System.out.printf("%d", res[i][j]);
                }
                System.out.println();
            }

            System.out.println("A = ");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.printf("%d", A[i][j]);

                }
                System.out.println();
            }

            System.out.println("B =");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.printf("%d", B[i][j]);

                }
                System.out.println();
            }
        }

    }

    public class TwoByTwoQuiz {
        public static void main(String[] args) {
            Matrix A = new Matrix();
            A.initArr(); // A 라는 행렬이 만들어짊. 메모리할당
            A.addMatrix(); // 행렬 덧셈
            A.printArr(); // 결과 출력

            Matrix B = new Matrix();
            B.initArr();

            /*
            2 * 2 행렬을 여러개 만들어야 할 경우에는 ?

             */
            Matrix multiMat[];
            multiMat = new Matrix[7];

            for (int i = 0; i < 7; i++) {
                multiMat[i] = new Matrix();
            }
        }
    }

