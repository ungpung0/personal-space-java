/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : Banner의 메소드를 연결하여 Print를 구현한다.
 **/

package adapter;

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    /**
     * showWithParen()을 호출한다.
     **/
    @Override
    public void printWeak() {
        showWithParen();
    }

    /**
     * showWithAster()를 호출한다.
     **/
    @Override
    public void printStrong() {
        showWithAster();
    }
}

/*
 *  이 클래스는 '적응자(Adapter)' 역할을 맡는다.
 *  적응자는 적응대상자(Adaptee)의 메소드를 사용하여 대상(Target)을 구현한다.
 */
