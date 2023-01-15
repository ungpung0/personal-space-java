/**
 * @Author : ungpung0
 * @Date    : 23/01/13
 * @Feature : 연습문제 풀이, Display에 랜덤 반복 기능을 추가한다.
 **/

package Bridge.practiece;

import Bridge.CountDisplay;
import Bridge.DisplayImpl;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    private Random random = new Random();
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * 무작위 값으로 반복하여 출력하는 메서드.
     **/
    public void randomDisplay(int times) {
        multiDisplay(random.nextInt(times));
    }
}

/*
    이 클래스는 '개선된 추상화(Refined Abstraction)' 역할을 수행한다.
    '추상화(Abstraction)' 클래스에 기능을 추가한다.
 */
