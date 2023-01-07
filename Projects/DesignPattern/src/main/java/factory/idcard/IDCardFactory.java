/**
 * @Author : ungpung0
 * @Date    : 23/01/07
 * @Feature : CharDisplay, StringDisplay에서 구현할 템플릿 메서드를 선언한다.
 **/

package factory.idcard;

import factory.framework.Factory;
import factory.framework.Product;

public class IDCardFactory extends Factory {
    /**
     * IDCard의 인스턴스를 생성하는 메서드.
     * @param owner
     *          카드에 들어갈 사용자명
     **/
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    /**
     * 인스턴스명을 출력하는 메서드.
     * @param product
     *          Product 객체
     **/
    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}

/*
    이 클래스는 '구체적인 작성자(Concrete Creator)' 역할을 수행한다.
    구체적인 제품을 만들 클래스를 반환한다.
*/
