/**
 * @Author : ungpung0
 * @Date    : 23/01/25
 * @Feature : 연습 문제 풀이, 파일의 전체 경로를 출력하는 메서드를 추가한다.
 **/

package composite.practiece;

public abstract class _Entry {
    private _Entry parent;
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

    /**
     * 파일 전체 경로를 출력하는 메서드.
     **/
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        _Entry entry = this;
        do {
            fullName.insert(0, entry.getName());
            fullName.insert(0, "/");
            entry = entry.parent;
        }while(entry != null);
        return fullName.toString();
    }
}

/*
    이 클래스는 '컴포넌트(Component)' 역할을 수행한다.
    '컴포넌트(Component)'는 '잎(Leaf)'와 '복합체(Composite)'를 동일시하여 상위 클래스 역할을 맡는다.
*/