package day12;

public class DoubleArray {
    public static void main(String[] args) {
        /*
            이중배열
            1. 수학에서는 행렬 연산을 풀 경우에 사용함
            2. 연립 방정식도 가우스-조르단 소거법(행렬)을 통해 계산 가능
            3. 로봇에 관심이 많다면 필수!
            4. 재고 관리 프로그램
         */
        int matrix[][];
        matrix = new int[3][3]; // 메모리 할당

        System.out.println("res =");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = i*3 + j + 1;
            }
            System.out.println(matrix[i][0] +" " +
                                matrix[i][1] + " " +
                                matrix[i][2]);
        }

        int tri[][] = new int[3][];
        int idx = 3;

        //Heap 사용하기 : 동적할당 / new를 쓰는 것들은 대부분 동적할당 / 컴파일타임/ 런타임에 동작한다./ cpu가 연산할 때 개입한다./ 속도가 느리다

        tri[0] = new int[3]; // 행렬중에 열은 가변적일 수 있다.
        tri[1] = new int[2];
        tri[2] = new int[1];

        System.out.println("res =");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < idx; j++) {

                // * 가변 배열 *
                tri[i][j] = i*3 + j + 1;

                //prinf -> format = 서식 -> 수치표현 필요할 때 용이한 표현방식이다.
                // %d는 숫자, %f는 소수점
                System.out.printf("%d ", tri[i][j]);

            }

            idx --;
            System.out.println();
        }
    }
}
