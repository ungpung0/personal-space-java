/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 장식틀을 나타내는 추상 클래스.
 **/

package decorator;

public abstract class Border extends Display {
    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}

/*
    이 추상 클래스는 Decorator(장식자) 역할을 수행한다.
    Decorator는 Component를 기반으로 추가할 인터페이스를 결정한다.
 */