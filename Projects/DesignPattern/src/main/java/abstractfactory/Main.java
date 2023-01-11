/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : List, Tray, Factory을 사용하여 프로그램을 실행한다.
 **/

package abstractfactory;

import abstractfactory.factory.Factory;
import abstractfactory.factory.Link;
import abstractfactory.factory.Page;
import abstractfactory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Main filename.html class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main list.html listfactory.ListFactory");
            System.out.println("Example 2: java Main div.html divfactory.DivFactory");
            System.exit(0);
        }

        String filename = args[0];
        String classname = args[1];

        Factory factory = Factory.getFactory(classname);

        // 블로그.
        Link blog1 = factory.createLink("Blog 1", "https://example.com/blog1");
        Link blog2 = factory.createLink("Blog 2", "https://example.com/blog2");
        Link blog3 = factory.createLink("Blog 3", "https://example.com/blog3");

        Tray blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        // 뉴스.
        Link news1 = factory.createLink("News 1", "https://example.com/news1");
        Link news2 = factory.createLink("News 2", "https://example.com/news2");
        Tray news3 = factory.createTray("News 3");
        news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"));
        news3.add(factory.createLink("News 3 (KR)", "https://example.com/news3kr"));

        Tray newsTray = factory.createTray("News Site");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        // 페이지.
        Page page = factory.createPage("Blog and News", "Youngjin.com");
        page.add(blogTray);
        page.add(newsTray);

        page.output(filename);
    }
}

/*
    이 클래스는 '의뢰인(Client)' 역할을 수행한다.
    '추상적인 부품(Abstract Component)', '추상적인 제품(Abstract Product)' API를 사용한다.
 */