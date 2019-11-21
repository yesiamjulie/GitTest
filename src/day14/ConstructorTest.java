package day14;

import java.rmi.server.RMIClassLoader;

class Student_ {

    String name;
    String major;
    String minor;
    int age;

    // 생성자 : public + 클래스이름

    /*
     public Student_(){

         this("홍길동", "삽집", "맨땅헤딩", 23);

     }

     */

    /*
        생성자는 리턴 타입이 없다.
        즉 void도 적지 않는다.
        그리고 특징이라면 class이름과 생성자의 이름은 동일하다.
        ( class이름과 같은 것이 있다면 '생성자'라고 생각하면 된다 .)

        이 녀석은 new를 하는 시점에 동작하게 된다.

         ******* 생성자는 오버로딩이 가능하다!
         오버로딩이란?
         - 로딩 : 메모리에 올린다.
         - 오버 : 위에 덮어 쓴다.
         즉 오버로딩이란 같은 이름의 메소드를 여러개 만들 수 있다는 의미!

         **조건 : 인자의 개수나 인자의 타입이 달라야 한다.

     */


    public Student_() { // case 1 : 인자 없는 경우
        System.out.println("생성자 시작");
                name = "아무개";
                major = "삽집";
                minor = "맨땅헤딩";
                age = 23;


    }

    /*
       case 2 : 인자 4개짜리 생성자

     */
    // 생성자는 return이 없다. 출력이 없다. 하지만 인자는 있다. 즉 입력을 줄 수 있다.
    public Student_(String n, String ma, String mi, int a){
        System.out.println("인자 4개짜리 생성자");
        name = n;
        major = ma;
        minor = mi;
        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "name =" + name +
                ", major =" + major +
                ", minor = " + minor +
                ", age =" + age + "\n";
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
        System.out.println("생성자 시작 전");
        Student_ stu = new Student_(); // new : 메모리를 할당 한다 !
        System.out.println("생성자 시작 후 ");
        System.out.println(stu);

        System.out.println("생성자 시작 전");
        Student_ stu2 = new Student_("김길동", "의적", "강탈", 27);
        System.out.println("생성자 시작 후");
        System.out.println(stu2);

    }
// 동적, 정적,
// 객체( 메모리에 할당 된 것 -> 셋팅한다는 것 -> 생성자가 있으면 디폴트 값으로 생성되고, 없으면 비어있게 된다. )
// ** 이 개념은 정확히 알자.

    /*

     숙제8 . 문제은행
     (2. 지역변수 vs new로 만든 것들.)

     5,6, 10번

     5. 1, 3, 4, 7, 11, 18, 29, 47, 76, ... 형태로 숫자가 진행된다.
        23 번째 숫자는 무엇일까 ?
        (프로그래밍 하시오)

     6. 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ... 형태로 숫자가 진행된다.
        1 ~ 57 번째까지의 수들로 홀수들의 합을 하고 짝수들의 합을 구한다.
        홀수들의 합 - 짝수들의 합의 결과를 출력하시오.

     10. 다음을 적분하는 프로그램을 만들어보자! (배점: 5 점)
         3x^2 + 7x 를 1 ~ 2 까지 정적분하도록 구현해보자git !


     단, 5~6번은 클래스를 응용하며, 생성자를 사용하도록 한다. ( initArray 대신 생성자)
     10번은 델타값=h을 잘 잡아야 한다.


     */
}
