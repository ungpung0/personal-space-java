/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 연습 문제 풀이, 증가하는 숫자를 생성하는 클래스.
 **/

package observer.practiece;

import observer.NumberGenerator;

import java.util.Random;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int numberIncrement;
    private int numberCurrent;
    private int numberMaximum;

    public IncrementalNumberGenerator(int numberCurrent, int numberMaximum, int numberIncrement) {
        this.numberCurrent = numberCurrent;
        this.numberMaximum = numberMaximum;
        this.numberIncrement = numberIncrement;
    }

    /**
     * 숫자를 반환하는 메서드.
     **/
    @Override
    public int getNumber() {
        return numberCurrent;
    }

    /**
     * 무작위로 숫자를 생성하는 메서드.
     **/
    @Override
    public void execute() {
        for(int i = numberCurrent; i < numberMaximum; i += numberIncrement) {
            numberCurrent = i;
            notifyObservers();
        }
    }
}

/*
    이 클래스는 Concrete Subject(구체적인 관찰 대상자) 역할을 수행한다.
    Concrete Subject는 Subject를 구현하여 현재 상태를 취득한다.
 */