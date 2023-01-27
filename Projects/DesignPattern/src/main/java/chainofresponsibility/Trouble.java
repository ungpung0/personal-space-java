/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 발생한 트러블을 나타내는 클래스.
 **/

package chainofresponsibility;

public class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    /**
     * 문제의 번호를 반환하는 메서드.
     **/
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}
