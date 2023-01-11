/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Link와 Tray를 동일시하기 위한 클래스.
 **/

package abstractfactory.factory;

public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    /**
     * HTML의 문자열을 반환하는 메서드.
     **/
    public abstract String makeHTML();
}

/*
    이 클래스는 '추상적인 부품(Abstract Component)' 역할을 수행한다.
    '추상적인 공장'에서 호출되어 생성되는 부품의 일종이다.
*/