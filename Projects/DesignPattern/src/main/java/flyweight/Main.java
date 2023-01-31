/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package flyweight;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }
        BigString bs = new BigString(args[0]);
        bs.print();
    }
}
