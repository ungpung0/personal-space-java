/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : 반복에 필요한 hasNext(), next()를 결정한다
 * */

package iterator;

public interface Iterator<E> {
    public abstract boolean hasNext();

    public abstract E next();
}

/*
 * 이 인터페이스는 '반복자(Iterator)' 역할을 맡는다.
 * 반복자는 요소를 탐색하는 인터페이스(API)를 결정한다.
 */