package day8;

public class ArrayTest {
    // 데이터 처리를 잘 하기 위한 배열

    public static void main(String[] args) {

        final int MEMBERS = 30;

        /*
            -배열을 선언하는 방법

            1. 데이터 타입을 적는다.
            2. 데이터 타입 뒤에 '[]' ( 대괄호 )를 배치한다.
            3. 변수명을 적어주듯이 배열의 이름을 적어준다.
               (이것도 역시 구별이 가능하게 적어주는 것이 좋다.)
            4. 마지막으로 ';' 를 붙여서 마무리한다.

            int[] scores; 이와같이 하면 선언은 마무리 된다고 볼 수 있다.
            ( 의미 : int형의 데이터를 여러 개 사용할 것입니다.
            그리고 그 대표격의 이름을 scores로 사용할 것입니다.
            즉 , " 저는 여러개의 int를 배치할 수 있는 변수를 사용하겠습니다. ")


            Java에서는 Stack과 Heap만 알면 된다.
            Stack은 지역 변수가 배치된다.
            Heap은 new로 할당된 것들이 배치된다.

            -배열을 Heap에 할당하는 방법

            1. 우선 배열을 선언한다.
            2. new를 쓴다.
            3. 배치될 배열의 데이터 타입을 적는다.
            4. 이후, '[]' 대괄호 안쪽에 몇 개를 할당할 지 개수를 적는다.

            new int[MEMBERS] -----> new int[30]
            (의미 : " 저는 Heap에 30개의 int형 공간을 배치하겠습니다 " )

         */
        int[] scores = new int[MEMBERS];

        for (int i = 0; i < 15; i++) {

            scores[i] = (i + 1) * 3;
            System.out.println("res = " + scores[i]);

        }

        scores[27] = 1;

        for (int i = 0; i < MEMBERS; i++) {
            System.out.println("scores["+ i + "] =" + scores[i]);
        }

    }
}