/**
 * @Author : ungpung0
 * @Date    : 23/01/05
 * @Feature : 완성한 프로그램을 테스트한다.
 **/


package template;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello World!");

        d1.display();
        d2.display();
    }
}
