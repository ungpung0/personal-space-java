/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : AbstractDisplay의 추상 메서드를 char형에 맞게 구현한다.
 **/

package template;

public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    /**
     * "<<"를 출력하는 메서드.
     **/
    @Override
    public void open() {
        System.out.print("<<");
    }

    /**
     * 문자 ch를 출력하는 메서드.
     **/
    @Override
    public void print() {
        System.out.print(ch);
    }

    /**
     * ">>"를 출력하는 메서드.
     **/
    @Override
    public void close() {
        System.out.println(">>");
    }
}

/*
 * 이 클래스는 '구현 클래스(Concrete Class)'이다.
 * 구현 클래스는 추상 메서드를 구체적으로 구현한다.
 */