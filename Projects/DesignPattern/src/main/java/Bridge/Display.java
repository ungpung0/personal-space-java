/**
 * @Author : ungpung0
 * @Date    : 23/01/13
 * @Feature : DisplayImpl 인스턴스를 생성하여 표시 기능을 제공한다.
 **/

package Bridge;

public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    /**
     * 시작할 때 특수기호를 출력하는 메서드.
     **/
    public void open() {
        impl.rawOpen();
    }

    /**
     * 문자열을 출력하는 메서드.
     **/
    public void print() {
        impl.rawPrint();
    }

    /**
     * 끝날 때 특수기호를 출력하는 메서드.
     **/
    public void close() {
        impl.rawClose();
    }

    /**
     * open(), print(), close()를 순서대로 호출하는 메서드.
     **/
    public final void display() {
        open();
        print();
        display();
    }
}

/*
    이 클래스는 '추상화(Abstraction)' 역할을 수행한다.
    기능의 클래스 계층의 최상위 클래스이다.
 */