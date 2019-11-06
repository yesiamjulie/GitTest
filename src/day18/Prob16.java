package day18;

//문제 16. Bank 클래스를 작성하시오.


/*
    이 문제에서 사용한 개념
    0. 클래스 작성법
    1. 형 변환 ( 타입 캐스팅 ) 복습


 */
import java.util.Random;
import java.util.Scanner;

class Bank{
    int money;
    Scanner in;
    Random rand;
    float interRate; // 이자

    public Bank(){

        in = new Scanner(System.in);
        rand = new Random();
    }
    public void deposit(){
        System.out.println(" 입금 할 금액을 입력하세요 : ");
        money = in.nextInt();
    }
    public void setInterRate(){
        interRate = (float)(rand.nextInt(301) + 100) /100.0f;
    }


    //이자율이 있으니까 그만큼 갱신이 필요
    public void applyInteRate(){
        money = (int)(money * (1.0f + interRate / 100.0f));
    }

    @Override
    public String toString() {
        return "현재 금액 =" + money +
                ", 이자율 =" + interRate;
    }
}
public class Prob16 {

    public static void main(String[] args) {
        Bank bk = new Bank();
        bk.deposit();
        bk.setInterRate();

        System.out.println(bk);

        bk.setInterRate();
        bk.applyInteRate();
        System.out.println(bk);
    }
}
