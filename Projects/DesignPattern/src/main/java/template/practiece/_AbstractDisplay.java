/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : AbstractDisplay를 인터페이스로 변환한다.
 **/

package template.practiece;

public interface _AbstractDisplay {
    public void open();

    public void print();

    public void close();

    /**
     * open()을 1번, print()를 5번, close()를 1번 호출하는 익명 메서드.
     **/
    public default void display() {
        open();
        for(int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
