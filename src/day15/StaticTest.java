package day15;

class StaticCnt {


    //static으로 선언한 '변수'는 data 영역에 배치된다.
    //**즉, 전역 변수화가 됩니다. ** 전역변수 : 언제어디서든 접근할 수 있다. 접근제한을 포함하지 않는다 ( vs C Language)

    static int cnt =  0;

    public  StaticCnt(){

        cnt++;
        System.out.println("cnt = " + cnt);

    }
}
public class StaticTest {

    // 메모리 할당 없이 바로 쓸 수 있는 static이 붙은 함수.
    public static void test(){
        System.out.println("test");
    }
    /*
     (+) new로 할당한 것들은 Heap으로 할당되게되는데 이 경우에 굉장히 느리다.
     이 경우를 감안한다면 대신 static을 써도 좋다. 하지만 너무 많이 쓰게되면 메모리가 버거워한다.
     왜냐하면 이미 로드되어잇기 때문에 로딩시간이 길어지게 된다. 즉 할당속도는 떨어지지만 반응속도는 빨라진다.

     */

    /*
         함수가 전역 변수화??
         함수는 text 영역인데??!! Why?

         함수에 static이 붙는 것은 변수와는 동작이 다르다.
         메모리 할당 전에 이미 로드가 완료되어있음.
     */
    public static void main(String[] args) {
        StaticCnt sc1 = new StaticCnt();
        StaticCnt sc2 = new StaticCnt();
        StaticCnt sc3 = new StaticCnt();

        test();
    }
}
