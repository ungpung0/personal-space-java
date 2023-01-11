/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Link나 Tray를 리스트로 묶는 클래스.
 **/

package abstractfactory.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Tray extends Item {
    protected List<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    /**
     * 리스트에 Item을 추가하는 메서드.
     **/
    public void add(Item item) {
        tray.add(item);
    }
}

/*
    이 클래스는 '추상적인 부품(Abstract Product)' 역할을 수행한다.
    '추상적인 공장'에서 호출되어 생성되는 부품의 일종이다.
*/