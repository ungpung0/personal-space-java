/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : HTML 페이지 전체를 추상적으로 표현한 클래스.
 **/

package abstractfactory.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {
    protected String title;
    protected String author;
    protected List<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Item(Link | Tray)를 리스트에 추가하는 메서드.
     * @param item
     *          추가할 Item
     **/
    public void add(Item item) {
        content.add(item);
    }

    /**
     * 파일명을 결정하여 HTML 내용을 파일로 기록한다.
     * @param filename 
     *          파일명
     **/
    public void output(String filename) {
        try {
            Files.writeString(Path.of(filename), makeHTML(),
                    StandardOpenOption.CREATE,            // 존재하지 않으면 새로 생성한다.
                    StandardOpenOption.TRUNCATE_EXISTING, // 존재하면 크기를 0으로 한다.
                    StandardOpenOption.WRITE);            // 기록한다.
            System.out.println(filename + " 파일을 작성했습니다.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * HTML을 문자열로 반환하는 메서드.
     **/
    public abstract String makeHTML();
}

/*
    이 클래스는 '추상적인 제품(Abstract Product)' 역할을 수행한다.
    '추상적인 공장'에서 호출되어 부품들을 하나로 모아서 생성되는 제품의 일종이다.
*/