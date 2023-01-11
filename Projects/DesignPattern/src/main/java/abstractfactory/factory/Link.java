/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : HTML 하이퍼링크를 추상적으로 표현하는 클래스.
 **/

package abstractfactory.factory;

public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}

/*
    이 클래스는 '추상적인 부품(Abstract Component)' 역할을 수행한다.
    '추상적인 공장'에서 호출되어 생성되는 부품의 일종이다.
*/