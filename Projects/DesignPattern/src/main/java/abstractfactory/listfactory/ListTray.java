/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Tray를 상속받아 HTML에서 사용할 ul 태그를 구현한다.
 **/

package abstractfactory.listfactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n");
        sb.append(caption);
        sb.append("\n<ul>\n");
        for(Item item : tray) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}

/*
    이 클래스는 '구체적인 부품(Concrete Component)' 역할을 수행한다.
    '구체적인 공장'에서 호출되어 생성되는 부품의 일종이다.
*/