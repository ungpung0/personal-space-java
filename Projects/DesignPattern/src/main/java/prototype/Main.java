/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : 완성한 프로그램을 테스트한다.
 **/

package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox1 = new MessageBox('*');
        MessageBox mbox2 = new MessageBox('/');

        manager.register("Strong Message", upen);
        manager.register("Warning Box", mbox1);
        manager.register("Slash Box", mbox2);

        Product product1 = manager.create("Strong Message");
        product1.use("Hello World");

        Product product2 = manager.create("Warning Box");
        product2.use("Hello World");

        Product product3 = manager.create("Slash Box");
        product3.use("Hello World");
    }
}
