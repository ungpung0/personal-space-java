/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 연습 문제 풀이, 디렉터리를 나타내는 추상 클래스.
 *            크기를 구할 때 SizeVisitor를 사용한다.
 **/

package visitor.practiece;

import visitor.Entry;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _Directory extends Entry implements Iterable<Entry> {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public _Directory(String name) {
        this.name = name;
    }

    /**
     * 디렉터리 이름을 반환하는 메서드.
     **/
    @Override
    public String getName() {
        return name;
    }

    /**
     * SizeVisitor 인스턴스를 통하여 디렉터리 크기를 반환하는 메서드.
     **/
    @Override
    public int getSize() {
        SizeVisitor sizeVisitor = new SizeVisitor();
        accept(sizeVisitor);
        return sizeVisitor.getSize();
    }

    /**
     * File|Directory를 다루는 Entry를 디렉터리에 추가하는 메서드.
     * @param entry
     *          추가할 Entry
     **/
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    /**
     * Entry 목록을 얻기위해 반복자를 반환하는 메서드.
     **/
    @Override
    public Iterator<Entry> iterator() {
        return directory.iterator();
    }

    /**
     * Directory 인스턴스를 visit()을 호출하여 전달하는 메서드.
     **/
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

/*
    이 클래스는 Concrete Element(구체적인 요소) 역할을 수행한다.
    Concrete Element는 Element의 요소를 구현한다.

    동시에 Object Structor(오브젝트 구조) 역할을 수행한다.
    Object Structor는 Concrete Visitor가 각 Element를 취급 가능하도록 메서드를 준비한다.
 */
