/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : Iterator 연습문제, 기존 Book[]을 List로 바꾸어 크기 제한을 없앤다.
 **/

package iterator.practiece;

import iterator.Book;
import iterator.Iterable;
import iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class _BookShelf implements Iterable<Book> {
    private List<Book> books = new ArrayList<>();
    private int last = 0;

    /**
     * 인덱스에 해당하는 book을 반환하는 메서드.
     * @param index
     *          탐색할 배열의 인덱스.
     **/
    public Book getBookAt(int index) {
        return books.get(index);
    }

    /**
     * books에 book을 추가하는 메서드.
     * @param book
     *          요소로 추가할 book.
     **/
    public void appendBook(Book book) {
        books.add(book);
        last++;
    }

    /**
     * 가리키고 있는 last를 반환하는 메서드.
     **/
    public int getLength() {
        return last;
    }

    /**
     * BookShelfIterator를 생성자를 호출하는 메서드.
     **/
    @Override
    public Iterator<Book> iterator() {
        return new _BookShelfIterator(this);
    }
}
