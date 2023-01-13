/**
 * @Author : ungpung0
 * @Date    : 23/01/13
 * @Feature : Display에 반복 출력 기능을 추가한다.
 **/

package Bridge;

public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * 횟수(times) 만큼 반복해서 출력하는 메서드.
     * @param times 
     *          반복 횟수
     **/
    public void multiDisplay(int times) {
        open();
        for(int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}

/*
    이 클래스는 '개선된 추상화(Refined Abstraction)' 역할을 수행한다.
    '추상화(Abstraction)' 클래스에 기능을 추가한다.
 */
