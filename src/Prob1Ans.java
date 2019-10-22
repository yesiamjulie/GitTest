public class Prob1Ans {
    public static void main(String[] args) {

        int i = 1;

        while( i++ < 100) {
            if (i % 3 == 0) {

                System.out.println("3의 배수 : " + i);
            }
//          i++;
        }

        /* whlie문 사용하는 다른 방법
        while (i < 101) {
            if (i % 3 == 0) {
                System.out.println(" i = " + i);

            }
            i++;
        }
    */
        /* for문 사용하는 다른 방법
        for (i = 1; i++ < 101) {
            if(i%3 == 0){
                System.out.println("i = " + i);
            }
        }

         */


    }
}
