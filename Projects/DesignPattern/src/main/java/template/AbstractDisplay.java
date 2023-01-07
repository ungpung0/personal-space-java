/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : CharDisplay, StringDisplay에서 구현할 템플릿 메서드를 선언한다.
 **/

package template;

public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    /**
     * open()을 1번, print()를 5번, close()를 1번 호출하는 메서드.
     **/
    public final void display() {
        open();
        for(int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}

/*
 * 이 클래스는 '추상 클래스(Abstract Class)'이다.
 * 추상 클래스는 템플릿 메소드에서 사용할 추상 메서드를 선언한다.
 */