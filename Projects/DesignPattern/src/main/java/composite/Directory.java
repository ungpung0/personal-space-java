/**
 * @Author : ungpung0
 * @Date    : 23/01/25
 * @Feature : 디렉터리 구조에서 폴더 역할을 담당한다.
 **/


package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    /**
     * 디렉터리의 이름을 반환하는 메서드.
     **/
    @Override
    public String getName() {
        return name;
    }

    /**
     * 디렉터리의 크기를 반환하는 메서드.
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
     * 디렉터리의 목록을 출력하는 메서드.
     * @param prefix
     *          추가할 접두사
     **/
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for(Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    /**
     * 디렉터리에 파일|디렉터리(Entry)를 추가하는 메서드.
     * @param entry
     *          추가할 엔트리
     **/
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}

/*
    이 클래스는 '복합체(Composite)' 역할을 수행한다.
    복합체는 '잎(Leaf)'과 다른 '복합체(Composite)'를 클래스의 내용물로 사용할 수 있다.
*/