package day16;

class Profess2 extends Student{
    Boolean ph;

    public Profess2(String n, int a, String major, Boolean ph) {
        super(n, a, major);
        this.ph = ph;
    }

    @Override
    public String toString() {
        String tmp;

        if(ph){
            tmp = " 박사학위 보유";
        }else {
            tmp = " 박사학위 미보유";
        }
      return "이름 = " + name +
                ", 전공 =" + major +
                ", 나이 =" + age +
                ", 박사학위 여부 = " + tmp;
    }
}

public class ExtendsProfessorTest {
    public static void main(String[] args) {

        Profess2 p = new Profess2("마동석", 33, "수학", true);
        System.out.println(p);

    }
}
