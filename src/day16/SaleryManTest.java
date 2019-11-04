package day16;

class SaleryMan extends Student {
    int salary;

    public SaleryMan(String n, int a, String major, int salary) {
        super(n, a, major);
        this.salary = salary;
    }

    @Override
    public String toString() {
        String tmp;


        return "이름 = " + name +
                ", 전공 =" + major +
                ", 나이 =" + age +
                ", 연봉 = " + salary;
    }
}

public class SaleryManTest {
    public static void main(String[] args) {
        SaleryMan s = new SaleryMan("이종혁", 53, "물리학", 90000000);
        System.out.println(s);
    }
}
