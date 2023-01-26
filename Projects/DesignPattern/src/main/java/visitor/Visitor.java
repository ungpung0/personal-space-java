/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 파일과 디렉터리를 순회하는 방문자를 나타내는 추상 클래스.
 **/

package visitor;

import visitor.practiece._Directory;

public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);

    public abstract void visit(_Directory directory);
}

/*
    이 추상 클래스는 Visitor(방문자) 역할을 수행한다.
    Visitor는 Element의 요소들을 순회하는 방문자를 의미한다.

    Concrete Vistor와 Concrete Element의 조합으로 처리하는 것을 더블 디스패치(Double Dispatch)라고 한다.
 */