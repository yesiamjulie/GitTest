package day16;

/*
        상속, extends를 기억하자.
        상속이란?
        # 재산 상속(물건, 재화)


        Java 상속은 물건을 상속 받는다고 생각하면 된다.
        (클래스에 있는 변수와 메서드를 자신의 것인 것 처럼 활용할 수 있다.)

        예를들어 ,
        학생은 사람이라는 범주에 포함됨
        자동차는 탈 것이라는 범주에 포함됨
        비행기는 역시 탈 것이라는 범주에 포함됨.

        class Professor - 이름, 나이 , 전공, 박사학위 여부
        class Student - 이름, 나이 ,전공
        class Person - 이름, 나이
        class Vehicle - 속도, 색상
        class Automotive - 속도, 색상, 2륜이냐 4륜이나 등등
        class Airplane - 속도, 색상, 날개 유무

        이와 같이 중복되는 것들을
        공통적인 것으로 묶어서 관리하기 위해 상속 개념이 만들어짐
 */

/* 상속이 없는 경우
class Student {
    String name;
    String major;
    int age;


    public Student(String n, String m,int a) {
        name = n;
        major = m;
        age = a;
    }

    public String toString() {
        return "이름 =" + name + " , 전공 = " + major + ", 나이 =" + age;
    }
}

*/

class Person {
    String name;
    int age;


    public Person(String n,int a) { // 3. person 생성자는 두가지 입력값을 받습니다.

        System.out.println("Person 생성자");
        name = n;
        age = a;
    }

    public String toString() {
        return "이름 =" + name + " , 나이 =" + age;
    }
}

//extends가 상속을 하겠다는 의미
class Student extends Person {
    String major;

    public Student(String n, int a, String major) {

        /*
            Super는 나의 부모 클래스(생성자)를 호출한다.
            여기서 주의할 것은
            super보다 먼저 실행할 수 있는 것은 없다는 것이다.
            그러므로 반드시 먼저 super를 진행한 이후에
            그 다음 코드를 작성해야 한다.
         */
        super(n, a);  // 4. person 생성자 -> student 생성자
        System.out.println("Student 생성자");
        this.major = major;
    }

    @Override
    public String toString() {
        return "이름 = " + name +
                ", 전공 = " + major +
                ", 나이 =" + age;
    }
}

/* 상속 없이 구현한 Police 클래스  -> 상속을 활용해 다시 작성해보자.
class Police {
    String name;
    String grade;
    int age;

    public Police(String n, String g, int a) {
        name = n;
        grade = g;
        age = a;
    }

    public String toString(){
        return "이름 = " + name +
                ", 직급 = " + grade +
                ", 나이 = " + age;
    }
}
*/

// 상속을 활용하여 매우 간결해진 코드!
class Police extends Person{
    String grade;

    public Police(String n, int a, String grade) {
        super(n, a);
        this.grade = grade;
    }

    public String toString(){
        return "이름 = " + name +
                ", 직급 = " + grade +
                ", 나이 = " + age;
    }


}


//문제 7-1 . 상속없이 교수 클래스를 작성해보시오.

class Professor{

    String name;
    String major;
    String gender;
    int age;

    public Professor(String n, String m, String g, int a) {
        name = n;
        major = m;
        gender = g;
        age = a;
    }

    public String toString(){
        return "이름 = " + name +
                ", 전공 = " + major +
                ", 성별 = " + gender +
                ", 나이 = " + age;
    }


}

// 문제 7-2 . 상속을 활용하여 교수 클래스를 작성해보십시오.

class Professor2 extends Student{
   String gender;

    public Professor2(String n, int a, String major, String gender) {
        super(n, a, major);
        this.gender = gender;
    }

    public String toString() {
        return "이름 = " + name +
                ", 전공 = " + major +
                ", 성별 = " + gender +
                ", 나이 =" + age;
    }
}

//  문제 7-3 . 상속을 활용하여 회사원 클래스를 작성해보시오.

class Employee extends Person{
    String job;
    String grade;

    public Employee(String n, int a, String job, String grade) {
        super(n, a);
        this.job = job;
        this.grade = grade;
    }

    public String toString() {
        return "이름 = " + name +
                ", 직업 = " + job +
                ", 직급 = " + grade +
                ", 나이 =" + age;
    }

}

public class ExtendsTest {
    public static void main(String[] args) { // 1. 항상 프로그램의 시작은 "main"
        Person p = new Person("고현서", 28); // 2. person의 생성자를 생성했습니다.
        System.out.println(p);

        Student s = new Student("홍길동", 30, "컴퓨터");
        System.out.println(s);

        Police pol = new Police("나경찰", 33,"순경");
        System.out.println(pol);

        Professor pro = new Professor("김교수", "통계", "남자", 45);
        System.out.println(" 7-1\n"  + pro);
        System.out.println();

        Professor2 pro2 = new Professor2("조교수", 60, "전자", "여자");
        System.out.println("7-2\n" + pro2);
        System.out.println();

        Employee em = new Employee("7-3\n" + "회사원A", 29, "영업", "대리");
        System.out.println(em);

    }
}
/*
    문제 7-1 . 상속없이 교수 클래스를 작성해보시오.
    문제 7-2 . 상속을 활용하여 교수 클래스를 작성해보십시오.
    문제 7-3 . 상속을 활용하여 회사원 클래스를 작성해보시오.
 */
