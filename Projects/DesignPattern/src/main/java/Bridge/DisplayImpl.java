/**
 * @Author : ungpung0
 * @Date    : 23/01/13
 * @Feature : Display의 기능에 필요한 메서드를 구현한다.
 **/

package Bridge;

public abstract class DisplayImpl {
    public abstract void rawOpen();

    public abstract void rawPrint();

    public abstract void rawClose();
}

/*
    이 클래스는 '구현자(Implementor)' 역할을 수행한다.
    구현의 클래스 계층의 최상위 클래스이다.
 */