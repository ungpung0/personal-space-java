/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : File과 Directory의 상위 추상 클래스.
 **/

package visitor;

public abstract class Entry implements Element {
    public abstract String getName();

    public abstract int getSize();

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}