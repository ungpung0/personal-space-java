/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : Gamer의 상태를 나타내는 클래스.
 **/

package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;
    private List<String> fruits;

    public Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    /**
     * 소지금을 반환하는 메서드.
     **/
    public int getMoney() {
        return money;
    }

    /**
     * 과일을 추가하는 메서드.
     **/
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    /**
     * 과일들을 반환하는 메서드.
     **/
    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }
}

/*
    이 클래스는 Memento(기념품) 역할을 수행한다.
    Memento는 Originator의 내부 정보를 정리하여 가지게 된다.

    Memento는 두 종류의 API를 제공한다.
    1) Wide Interface : 오브젝트의 상태를 외부에서 활용하기 위해 정보를 제공하는 메서드 집합.
    2) Narrow Interface : 정보를 한정적으로 제공하여 내부 상태를 외부에 공개하는 것을 방지하는 메서드 집합.
*/
