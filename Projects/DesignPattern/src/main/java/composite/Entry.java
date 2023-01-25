/**
 * @Author : ungpung0
 * @Date    : 23/01/25
 * @Feature : 파일과 디렉터리를 취합하는 역할을 담당한다.
 **/

package composite;

public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}

/*
    이 클래스는 '컴포넌트(Component)' 역할을 수행한다.
    '컴포넌트(Component)'는 '잎(Leaf)'와 '복합체(Composite)'를 동일시하여 상위 클래스 역할을 맡는다.
*/