package day17;

interface Comparable {
    int compareTo(Object other); // 반드시 override해주어야 한다.
}

/*
    interface로 만든 것은 반드시 implements로 받는다.
    abstract와 차이점이라면, abstract는 변수와 메서드 모두 사용하며
    interface는 매서드만 사용한다는 것이다.
 */
class StrcmpTest implements Comparable{
    private double area = 0;

    public StrcmpTest(double a) {
        area = a;
    }

    /* Override란 ?
       Abstract Class와 마찬가지로
       interface 또한 메서드를 상속 혹은 구현부에서 처리해야 한다. ( 예 : AbstractTest.java 구현 참고 )
       그렇기에 상속 혹은 구현을 받아온 것을 여기에 반드시 작성해줘야 한다.
       이러한 모든 것에는 Override가 붙는다.
       (c++에서는 virtual과 같은 기능이며
        c에서는 함수 포인터라고 보면 된다.)


        지금 여기서 만든 compareTo는
        c에서의 strcmp와 유사한 것을 만들었다 생각하면 된다.

        Object는 최상위 객체이므로
        어떠한 데이터 타입도 받을 수 있다.
        (String), (int), (dobule)
        어떠한 것이로든 변화를 시킬 수 있다.


        이러한 특징을 가진 interface(abstract포함)는 어디에 쓰이기 좋을까?
        -게임에서 다양한 캐릭의 속성들을 달리할때?
     */
    @Override
    public int compareTo(Object other) {
        StrcmpTest st = (StrcmpTest)other;

        if (area < st.area) {
            return  -1;
        } else if (area > st.area) {
            return 1;
        }else{
            return 0;
        }
    }


    //C로 치면 void *(void 포인터) 라고 보면된다.
    public void test(Object obj) {
        System.out.println(obj);
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        StrcmpTest st1 = new StrcmpTest(77.3);
        StrcmpTest st2 = new StrcmpTest(33.7);
        StrcmpTest st3 = new StrcmpTest(33.6);

        if(st1.compareTo(st2) != 0) {
            System.out.println("두 숫자는 같지 않다.");
        }
        if(st1.compareTo(st3) != 0){
            System.out.println("두 숫자는 같지 않다.");
        }
        if(st2.compareTo(st3) != 0){

            System.out.println("두 숫자는 같지 않다.");

        }else{
            System.out.println("두 숫자는 같다.");
        }


    }
}
