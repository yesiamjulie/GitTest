package day18;
//문제 8. 정수형 변수 2개, 4 byte형 소수점 변수 1개, 8 byte형 소수점 변수 1개를 만들고 출력하시오.
class Numbers {
    private int one, two;
    private float fOne;
    private double dOne;

    public Numbers(int one, int two, float f, float d) {
        this.one = one;
        this.two=two;
        fOne = f;
        dOne = d;
    }

    //공백 생성자를  만드는 이유?
    public Numbers(){
        this(0, 0, 0, 0);
    }



    public void setOne(int one) {
        this.one = one;
    }


    public void setTwo(int two) {
        this.two = two;
    }


    public void setfOne(float fOne) {
        this.fOne = fOne;
    }



    public void setdOne(double dOne) {
        this.dOne = dOne;
    }

    @Override
    public String toString() {
        return "one =" + one +
                ",two = " + two +
                ",fOne = " + fOne +
                ",dOne = " + dOne ;
    }
}

public class Prob8 {
    public static void main(String[] args) {
        Numbers n = new Numbers(3, 7, 3.3f, 3);

        System.out.println(n);
    }
}
