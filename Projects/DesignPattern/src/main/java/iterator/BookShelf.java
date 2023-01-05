/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : Iterable를 구현하고, BookShelfIterator의 인스턴스를 생성한다.
 **/

package iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int size) {
        this.books = new Book[size];
    }

    /**
     * 인덱스에 해당하는 book을 반환하는 메서드.
     * @param index
     *          탐색할 배열의 인덱스.
     **/
    public Book getBookAt(int index) {
        return books[index];
    }

    /**
     * books[last]에 book을 추가하는 메서드.
     * @param book
     *          요소로 추가할 book.
     **/
    public void appendBook(Book book) {
        this.books[last] = book;
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
        return new BookShelfIterator(this);
    }
}

/*
 * 이 클래스는 '구체적인 집합체(Concrete Aggregate)' 역할을 맡는다.
 * '구체적인 집합체(Concrete Aggregate)'는 '집합체'의 API를 실제로 구현한다.
 */
