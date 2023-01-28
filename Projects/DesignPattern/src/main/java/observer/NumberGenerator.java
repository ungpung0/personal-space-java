/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 숫자를 생성하는 객체를 나타내는 추상 클래스.
 **/

package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Observer를 저장하는 메서드.
     * @param observer
     *          저장할 Observer
     **/
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Observer를 제거하는 메서드.
     * @param observer
     *          제거할 Observer
     */
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Observer에 통지하는 메서드.
     */
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}

/*
    이 클래스는 Subject(관찰 대상자) 역할을 수행한다.
    Subject는 Observer를 등록/삭제하는 메서드와 현재 상태를 취득하는 메서드를 정의한다.
 */