/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : Visitor 클래스 인스턴스와 호환되는 데이터 구조를 나타내는 인터페이스.
 **/

package visitor;

public interface Element {
    public abstract void accept(Visitor visitor);
}

/*
    이 인터페이스는 Element(요소) 역할을 수행한다.
    Element는 Vistor를 받아들이는 메서드를 선언하여 인수를 전달한다.
 */
