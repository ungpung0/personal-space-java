/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : Print에 필요한 실제 메서드를 구현한다.
 **/

package adapter;

public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    /**
     * String을 괄호로 감싸는 메서드.
     **/
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    /**
     * String을 *로 감싸는 메서드.
     **/
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}

/*
 *  이 클래스는 '적응대상자(Adaptee)' 역할을 맡는다.
 *  적응대상자는 대상(Target)의 구현에 필요한 메서드를 준비한다.
 */
