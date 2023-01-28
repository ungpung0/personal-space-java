/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package observer;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
