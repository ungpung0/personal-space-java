/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 완성한 프로그램을 테스트하는 클래스.
 **/

package decorator;

import decorator.practiece.MultiStringDisplay;
import decorator.practiece.UpDownBorder;

public class Main {
    public static void main(String[] args) {
        Display display1 = new StringDisplay("Hello World!");
        Display display2 = new SideBorder(display1, '#');
        Display display3 = new FullBorder(display2);

        display1.show();
        display2.show();
        display3.show();

        Display practiece1 = new UpDownBorder(display1);
        practiece1.show();

        MultiStringDisplay practiece2 = new MultiStringDisplay();
        practiece2.add("Hi!");
        practiece2.add("Good Morning.");
        practiece2.add("Good Night!");
        practiece2.show();
        Display practiece2Side = new SideBorder(practiece2, '#');
        practiece2Side.show();
    }
}
