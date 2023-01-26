/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 디렉터리를 나타내는 추상 클래스.
 **/

package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry implements Iterable<Entry> {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
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
     * 디렉터리 크기를 반환하는 메서드.
     **/
    @Override
    public int getSize() {
        int size = 0;
        for(Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
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
