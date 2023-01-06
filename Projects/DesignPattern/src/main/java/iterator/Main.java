/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : 완성한 프로그램을 테스트한다.
 **/

package iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);

        bookShelf.appendBook(new Book("Art Book"));
        bookShelf.appendBook(new Book("Math Book"));
        bookShelf.appendBook(new Book("Bible Book"));
        bookShelf.appendBook(new Book("English Book"));

        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
