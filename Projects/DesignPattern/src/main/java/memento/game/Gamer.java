/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : Memento 인스턴스를 생성하고, 게임을 플레이하는 클래스.
 **/

package memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private Random random = new Random();
    private List<String> fruits = new ArrayList<>();
    private static String[] fruitNames = {"사과", "포도", "바나나", "오렌지"};

    public Gamer(int money) {
        this.money = money;
    }

    /**
     * 소지금을 반환하는 메서드.
     **/
    public int getMoney() {
        return money;
    }

    /**
     * 과일을 획득하는 메서드.
     **/
    private String getFruit() {
        String fruit = fruitNames[random.nextInt(fruitNames.length)];
        if(random.nextBoolean()) {
            return "맛있는 " + fruit;
        }else {
            return fruit;
        }
    }

    /**
     * 게임을 진행하는 메서드.
     * 주사위가 1일 경우, 소지금이 100 증가한다.
     * 주사위가 2일 경우, 소지금이 절반으로 줄어든다.
     * 주사위가 6일 경우, 과일을 하나 받는다.
     * 주사위가 기타일 경우, 소지금이 변화하지 않는다.
     **/
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if(dice == 1) {
            money += 100;
            System.out.println("소지금이 증가했습니다.");
        }else if(dice == 2) {
            money /= 2;
            System.out.println("소지금이 반으로 줄었습니다.");
        }else if(dice == 6) {
            String fruit = getFruit();
            System.out.println("과일(" + fruit + ")를 받았습니다.");
            fruits.add(fruit);
        }else {
            System.out.println("변동사항이 존재하지 않습니다.");
        }
    }

    /**
     * 게임 정보를 임시 저장(스냅샷)하는 메서드.
     **/
    public Memento createMemento() {
        Memento memento = new Memento(money);
        for(String fruit : fruits) {
            if(fruit.startsWith("맛있는 ")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    /**
     * 스냅샷을 사용하여 복원하는 메서드.
     * @param memento 
     *          스냅샷
     **/
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
}

/*
    이 클래스는 Originator(작성자) 역할을 수행한다.
    Originator는 Memento를 사용하여 상태를 저장하고 복원할 수 있다.
*/