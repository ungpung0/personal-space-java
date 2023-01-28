/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 무작위로 숫자를 생성하는 클래스.
 **/

package observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();
    private int number;

    /**
     * 숫자를 반환하는 메서드.
     **/
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * 무작위로 숫자를 생성하는 메서드.
     **/
    @Override
    public void execute() {
        for(int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}

/*
    이 클래스는 Concrete Subject(구체적인 관찰 대상자) 역할을 수행한다.
    Concrete Subject는 Subject를 구현하여 현재 상태를 취득한다.
 */