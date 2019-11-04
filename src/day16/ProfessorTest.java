package day16;
//문제 7-1 . 상속없이 교수 클래스를 작성해보시오.

import java.util.PrimitiveIterator;

class Profess {
    private String name;
    private int age;
    private String major;
    Boolean ph; // 박사학위 여부

    public Profess(String n, int a, String m, Boolean p) {
        name = n;
        age = a;
        major = m;
        ph = p;
    }

    @Override
    public String toString() {
        String tmp;

        if (ph) {
            tmp = " 박사학위 보유";
        }else{
            tmp = " 박사학위 미보유";
        }
        return "이름 = " + name +
                ", 전공 =" + major +
                ", 나이 =" + age +
                ", 박사학위 여부 = " + tmp;
    }
}

public class ProfessorTest {
    public static void main(String[] args) {
        Profess p = new Profess("이교수", 40, "물리", true);
        System.out.println(p);
    }
}
