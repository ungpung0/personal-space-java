/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Factory의 메서드를 구현한다.
 **/

package abstractfactory.divfactory;

import abstractfactory.factory.Factory;
import abstractfactory.factory.Link;
import abstractfactory.factory.Page;
import abstractfactory.factory.Tray;

public class DivFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new DivLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new DivTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new DivPage(title, author);
    }
}

/*
    이 클래스 '구체적인 공장(Concrete Factory)' 역할을 수행한다.
    구체적인 제품(Concrete Product)의 인스턴스를 생성하기 위한 API를 구현한다.
 */