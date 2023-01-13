/**
 * @Author : ungpung0
 * @Date    : 23/01/13
 * @Feature : DisplayImpl의 메서드를 구현한다.
 **/

package Bridge;

public class StringDisplayImpl extends DisplayImpl {
    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.length();
    }

    /**
     * 출력이 시작할 때 printLine()을 호출하는 메서드.
     **/
    @Override
    public void rawOpen() {
        printLine();
    }

    /**
     * 문자열의 앞, 뒤에 특수기호를 붙여 출력하는 메서드.
     **/
    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    /**
     * 출력을 끝마칠 때 printLine()을 호출하는 메서드.
     **/
    @Override
    public void rawClose() {
        printLine();
    }

    /**
     * 문자열의 길이에 맞추어 특수기호를 추가하는 메서드.
     **/
    public void printLine() {
        System.out.print("+");
        for(int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}

/*
    이 클래스는 '구체적인 구현자(Concrete Implementor)' 역할을 수행한다.
    '구현자(Implementor)'을 구현하는 클래스이다.
 */