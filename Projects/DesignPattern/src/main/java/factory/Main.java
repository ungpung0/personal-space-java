/**
 * @Author : ungpung0
 * @Date    : 23/01/07
 * @Feature : 완성한 프로그램을 테스트한다.
 **/

package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product idCard1 = factory.create("Youngjin Kim");
        Product idCard2 = factory.create("Heungmin Son");
        Product idCard3 = factory.create("Kane");

        idCard1.use();
        idCard2.use();
        idCard3.use();
    }
}
