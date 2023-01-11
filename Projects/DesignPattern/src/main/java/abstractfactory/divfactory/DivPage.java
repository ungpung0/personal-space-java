/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Page를 상속받아 DivLink와 DivTray를 조립한다.
 **/

package abstractfactory.divfactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Page;

public class DivPage extends Page {
    public DivPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html><head><title>");
        sb.append(title);
        sb.append("</title><style>\n");
        sb.append("div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }\n");
        sb.append("div.LINK { padding:0.5em; background-color: lightgray; }\n");
        sb.append("</style></head><body>\n");
        sb.append("<h1>");
        sb.append(title);
        sb.append("</h1>\n");
        for(Item item : content) {
            sb.append(item.makeHTML());
        }
        sb.append("<hr><address>");
        sb.append(author);
        sb.append("</address>\n");
        sb.append("</body></html>\n");

        return sb.toString();
    }
}

/*
    이 클래스는 '구체적인 제품(Concrete Product)' 역할을 수행한다.
    '구체적인 공장'에서 호출되어 부품들을 하나로 모아서 생성되는 제품의 일종이다.
*/