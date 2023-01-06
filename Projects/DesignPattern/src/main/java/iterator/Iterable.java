/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : 프로그램에서 iterator 메소드를 결정한다.
 **/

package iterator;

public interface Iterable<E> {
    public abstract Iterator<E> iterator();
}

/*
 *  이 인터페이스는 '집합체(Aggregate)' 역할을 맡는다.
 *  집합체는 인터페이스(API)를 결정한다.
 */
