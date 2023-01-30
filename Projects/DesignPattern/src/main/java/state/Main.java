/**
 * @Author : ungpung0
 * @Date    : 23/01/30
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package state;

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for(int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                }
            }
        }
    }
}
