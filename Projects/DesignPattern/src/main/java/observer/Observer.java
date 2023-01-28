/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 숫자를 관찰하는 관찰자를 나타내는 인터페이스.
 **/

package observer;

public interface Observer {
    public abstract void update(NumberGenerator generator);
}

/*
    이 클래스는 Observer(관찰자) 역할을 수행한다.
    Observer는 Subject의 상태 변화를 받는 메서드를 정의한다.
 */