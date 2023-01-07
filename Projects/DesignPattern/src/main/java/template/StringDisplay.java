/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : AbstractDisplay의 추상 메서드를 char형에 맞게 구현한다.
 **/

package template;

public class StringDisplay extends AbstractDisplay {
    private String str;
    private int width;

    public StringDisplay(String str) {
        this.str = str;
        width = str.length();
    }

    /**
     * str의 길이에 맞춰서 "+-(length)+"를 출력하는 메서드.
     **/
    private void printLine() {
        System.out.print("+");
        for(int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    /**
     * printLine()을 호출하는 메서드.
     **/
    @Override
    public void open() {
        printLine();
    }

    /**
     * str의 앞뒤에 "|"를 추가하여 출력하는 메서드.
     **/
    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    /**
     * printLine()을 호출하는 메서드.
     **/
    @Override
    public void close() {
        printLine();
    }
}

/*
 * 이 클래스는 '구현 클래스(Concrete Class)'이다.
 * 구현 클래스는 추상 메서드를 구체적으로 구현한다.
 */
