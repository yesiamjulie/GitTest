package day16;

/*
    abstract 클래스에 있는 내용은
    반드시 생성자쪽에서 같이 처리해줘야 한다.
    상속을 받았지만 super로 처리하는 방식은 아니다!!!
    이것을 응용한 것이 interface인데
    super 처리 방식이 아니라 언제나 형태를 바꿀 수 있다.

    결론적으로, abstract는 같은 이름으로 여러 다른 기능을 구현할 수 있다.

 */
abstract class Message {
    public String subject;
    public String content;

    //메소드도 넣을 수  있어요.
    public void test() {
        System.out.println();
    }

    // 이것이 interface형태입니다.
}
class Messanger extends Message{
    private String sender;
    private String receiver;

    //자동완성에서 생성자를 만들때는   abstract부분은 super처럼 따라오지 않는다. 따라서 필요할 때에는 별도로 생성해야 한다..
    // 여기서는 subject, content
    public Messanger(String sender, String receiver, String subject, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.content= content;
    }

    private  void sendingCheck(){
        System.out.println("메시지를 보냅니다 ~");
    }
    public String toString(){
        sendingCheck();
        return "송신자 = " + sender +
                ", 수신자 =" + receiver +
                ", 제목 = " + subject +
                ", 내용 = " + content;
    }
}
public class AbstractTest {
    public static void main(String[] args) {
        Messanger m = new Messanger("Mom" , " Son", "Son, where are you?",
                "you are late school, Aren't you?");
        System.out.println(m);
    }
}
