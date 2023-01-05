/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : Iterator 연습문제, BookShelf를 _BookShelf로 변경한다.
 **/

package iterator;

import java.util.NoSuchElementException;

public class _BookShelfIterator implements Iterator<Book> {
    private _BookShelf bookShelf;
    private int index;

    public _BookShelfIterator(_BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    /**
     * index가 bookShelf의 길이보다 작을 경우 true를, 클 경우 false를 반환한다.
     **/
    @Override
    public boolean hasNext() {
        if(index < bookShelf.getLength()) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 현재 index의 book을 반환하고, index를 1 증가시킨다.
     **/
    @Override
    public Book next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
