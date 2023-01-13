/**
 * @Author : ungpung0
 * @Date    : 23/01/13
 * @Feature : 완성한 프로그램을 테스트한다.
 **/

package Bridge;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display display2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));

        display1.display();
        display2.display();
        display3.display();
        display3.multiDisplay(5);
    }
}
