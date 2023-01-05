/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : 타 클래스에 필요한 객체.
 **/

package iterator;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    /**
     * name을 반환하는 메소드.
     * */
    public String getName() {
        return name;
    }
}
