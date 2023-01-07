/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : String에 특수기호를 붙일 메서드를 결정한다.
 **/

package adapter;

public interface Print {
    public abstract void printWeak();

    public abstract void printStrong();
}

/*
 *  이 인터페이스는 '대상(Target)' 역할을 맡는다.
 *  대상은 프로그램에 필요한 메서드를 결정한다.
 */