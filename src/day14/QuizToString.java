package day14;

class Wizard{

    /*
    Good Abstraction :: private
     */
    // public 은 공용 ( 외부에 공개가 가능함 )
    // private은 전용 ( 내부에서만 사용 가능함 )

    private String name;
    private int level;
    private String skil;


    /*

     getter , setter 자동 생성 , toString: Alt + Insert

     */

    //get은 class 내부의 값을 가져올 때 사용
    //set은 class 내부의 값을 '설정'할 때 사용

    public String getName() {
        return name;
    }

    /* this는 자기 자신을 의미한다. */
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkil() {
        return skil;
    }

    public void setSkil(String skil) {
        this.skil = skil;
    }
//    public String toString(){
//        return "이름 =" + name + ", 레벨 =" + level +
//                ", 기술 =" + skil;
//    }


    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name + "\'\n" +
                "level='" + level +"\'\n" +
                "skil='" + skil + "\'\n" +
                '}';
    }
}
public class QuizToString {
    public static void main(String[] args) {

        Wizard w1 = new Wizard();
        w1.setName("Rang");
        w1.setLevel(10);
        w1.setSkil("이단옆차기");

        Wizard w2 = new Wizard();
        w2.setName("Hyun");
        w2.setLevel(15);
        w2.setSkil("회생");

        System.out.println(w1);
        System.out.println(w2);

    }

}
