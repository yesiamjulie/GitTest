package day21;

import org.w3c.dom.ls.LSOutput;


class A {
    private int num;

    public A() {
        num = 3;
        System.out.println("A Called");
    }
    int getNum(){
        return  num;
    }

    public interface Test {
       public void test();
    }


}

public class B{
    private int dst;



    public B(A a) {
        dst = a.getNum() * 2;
        System.out.println("B called = " + dst);
    }

    public void callInterface(Go l) {
            System.out.println("interface go");
    }

    public interface Go{
        void go();
    }
    }



public class AnonyTest {
    public static void main(String[] args) {
        A a = new A();
//        B b = new B(new A()); // 할당하지만 저장하지 않겠다는 의미. 일회용( 저장을 하지 않기 때문에)
//        B b = new B(new A.Test(){

           new A.Test() {
                public void test(){

                    System.out.println("Test");
                }
            };


    }
}
