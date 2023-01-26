/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 파일을 나타내는 클래스.
 **/

package visitor;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * 파일 이름을 반환하는 메서드.
     **/
    @Override
    public String getName() {
        return name;
    }

    /**
     * 파일 크기를 반환하는 메서드.
     **/
    @Override
    public int getSize() {
        return size;
    }

    /**
     * File 인스턴스를 visit()을 호출하여 전달하는 메서드.
     **/
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

/*
    이 클래스는 Concrete Element(구체적인 요소) 역할을 수행한다.
    Concrete Element는 Element의 요소를 구현한다.
 */