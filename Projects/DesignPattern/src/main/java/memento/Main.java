/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package memento;

import memento.game.Gamer;
import memento.game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();

        for(int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("상태:" + gamer);

            gamer.bet();

            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

            if(gamer.getMoney() > memento.getMoney()) {
                System.out.println("※소지금이 늘었으니 현재 상태를 저장합니다.");
                memento = gamer.createMemento();
            }else if(gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("※소지금이 줄었으니 이전 상태로 복원합니다.");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}

/*
    이 클래스는 Caretaker(관리인) 역할을 수행한다.
    Caretaker는 Originator에 요청하고 Memento를 저장하여 작동한다.
*/
