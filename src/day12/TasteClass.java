package day12;/*
    Good Abstraction 이란?

    1. 내가 표현하려는 class에 필요한 변수를 설정한다.
    2. 이 변수들을 제어할 수 있는 기능들이 존재한다.
    ------------------------------------------------

    3. 두 가지가 잘 갖춰진 상태에서
       접근 제어(private, public, protected)를 잘 활용하면
       이것은 Good Abstraction이라고 한다. ( 접근제어 : 쓸 수 없게함.)
       * 이 부분이 잘못될 경우 매일 야근하게 될 것이다. ( 즉 설계를 잘 해야 한다.)
         설계를 잘 하면 칼퇴할 확률이 올라갑니다.


 */

class Car {

    int speed;

    //String 클래스는 문자열을 저장할 수 있다.
    String color;

    /* 함수(method) 작성법

      1. 리턴 타입을  맨 앞에 적는다. ( 리턴 타입 :함수가 끝났을 때 출력할 값)
      2. 함수 이름을 리턴 타입 옆에 짓는다.
      3. 인자를 설정한다. ( 인자 : 입력)
      4. 기능을 block안에 작성한다.

    */
    void setSpeed(int s) { //void( 뜻 : 비어있다) , 즉 반환할 것이 없다.
                            // 인자를 두개 쓰고 싶다면 데이터 타입을 명시하고 두개를 써줘야 한다.
        speed = s;


    }

    int getSpeed() { // 인자쪽에 아무것도 없다면 , void와 같다.

        return speed;// 기능은 없고, speed를 출력하라

    }

}
public class TasteClass {
    public static void main(String[] args) {

        //Scanner in = new Scanner(System.in);
        Car myCar = new Car(); // Car라는 class를 myCar로 가져와서 new day12.Car()로 메모리를 할당하겠다. ( 힙에 메모리 공간을 만든다.)
        myCar.speed = 70; //"."은 클래스안에 있는 것을 사용하겠다는 것을 의미한다. 따라서 클래스에 없는 것은 사용할 수 없다.
        myCar.color = "Blue";

        Car myCar2 = new Car();
        myCar2.speed = 30;
        myCar2.color = "Red";

        myCar2.setSpeed(180);
        System.out.println("speed = " + myCar.getSpeed());

        System.out.printf("speed = %d, color = %s\n",
                            myCar.speed, myCar.color);
        System.out.printf("speed = %d, color = %s\n",
                            myCar2.speed, myCar2.color);
    }
    /*
    문제 6. class를 활용하여
    2 by 2 행렬의 덧셈을 구현하시오.
     */
}
