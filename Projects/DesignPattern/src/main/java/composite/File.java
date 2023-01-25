/**
 * @Author : ungpung0
 * @Date    : 23/01/25
 * @Feature : 디렉터리 구조에서 파일 역할을 담당한다.
 **/

package composite;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * 파일의 이름을 반환하는 메서드.
     **/
    @Override
    public String getName() {
        return name;
    }

    /**
     * 파일의 크기를 반환하는 메서드.
     **/
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 파일의 정보를 출력하는 메서드.
     * @param prefix
     *          추가할 접두사
     **/
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}

/*
    이 클래스는 '잎(Leaf)' 역할을 수행한다.
    잎은 내용물을 뜻하는데, 다른 잎(Leaf) 클래스를 내용물로 사용할 수 없다.
*/