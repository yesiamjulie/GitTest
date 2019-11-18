package day15;

/*
    3x^2 + 7x 를 1~2까지 정적분하시오. ( 넥슨 면접문제 )
 */
class Integral {
    int secondTerm;
    int firstTerm;
    float delta;
    float start;
    float end;
    float curX;
    int allSum;

    public Integral(float start , float end){
        secondTerm = 3;
        firstTerm = 7;
        delta = 0.0001f;
        curX = start;
        allSum = 0;
    }

    /* sum  (lim h-> 0  {f(x + h ) - f(x) } / h)
    *  f(x) = 3x^2 + 7x
    *  f(x+h) = 3(x+h)^2 + 7(x+h) */
    public void calcIntegral(){

        float temp;
        for (; curX < end; curX+= delta) {
            //밑변 * 높이
            temp = curX + delta;
            allSum +=  delta *
                    (secondTerm * (float)Math.pow(temp, 2.0) +
                    firstTerm * temp);
        }
    }
    public String toString(){
        return "3x^2 + 7x 를 1~1까지 정적분한 결과 =" +
                allSum;
    }
}
public class ProbBank10 {
    public static void main(String[] args) {
        Integral i = new Integral(1, 2);
        i.calcIntegral();
        System.out.println(i);
    }
}
