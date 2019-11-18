package day17;

interface skills{
    void skill1();
    void skill2();
    void skill3();
}

class Adventurer implements  skills{
    float atk, def,intel, vit, agl;


    public Adventurer(float a, float d, float i, float v, float ag) {

        atk = a;
        def = d;
        intel =i;
        vit = v;
        agl = ag;

    }
    public void skill1(){
        System.out.println("줍기");

    }
    public void skill2(){
        System.out.println("세게 때리기");

    }
    public void skill3(){
        System.out.println("빠르게 때리기");

    }
}

//게임이 업데이트되어 2차 전직이 되었다고 가정해보자.
// 하위 클래스를 쓰지 못한다. 이 경우에는 2차 전직을 하면 1차전직 스킬을 쓸 수 없다.

class Warrior extends Adventurer{
    float anger;

    public Warrior(float a, float d, float i,
                   float v, float ag, float ang){
        super(a, d, i, ag, ag);
        anger = ang;
        }

    public void skill1() {
        System.out.println("방패치기 ");
    }
    public void skill2() {
        System.out.println("휩쓸기");
    }
    public void skill3() {
        System.out.println("초절 강화");
    }

}
class Thief extends  Adventurer {
    public Thief(float a, float d,
                 float i, float v, float ag) {
        super(a, d, i, v, ag);
    }
    public void skill1(){ // 즉 ,스킬마다 데미지를 달리 줄 수도 있다,
        float tmp = agl * 10 + (atk + intel) * 3;
        System.out.println("급소 찌르기 = " + tmp);
    }

    public void skill2(){ // 즉 ,스킬마다 데미지를 달리 줄 수도 있다,
        float tmp =(atk + intel) * 2;
        System.out.println("중독 : 초당= " + tmp + "데미지");

    }
    public void skill3(){ // 구조 애플리케이션에서는 필수적으로 쓰이게 된다.
        float tmp =0;
        System.out.println("은신 : 30초 유지");

    }
}

public class GameTest {
    public static void main(String[] args) {
        Adventurer adv = new Adventurer(10, 10, 10, 10, 10);
        adv.skill1();
        adv.skill2();
        adv.skill3();

        Warrior war = new Warrior(

                70,55, 25, 50, 30 , 11);
        war.skill1();
        war.skill2();
        war.skill3();



    }
}
