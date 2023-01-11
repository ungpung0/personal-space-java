/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Link를 상속받아 HTML에서 사용할 li 태그를 구현한다.
 **/

package abstractfactory.listfactory;

import abstractfactory.factory.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}

/*
    이 클래스는 '구체적인 부품(Concrete Component)' 역할을 수행한다.
    '구체적인 공장'에서 호출되어 생성되는 부품의 일종이다.
*/