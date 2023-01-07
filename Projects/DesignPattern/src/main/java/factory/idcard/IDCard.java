/**
 * @Author : ungpung0
 * @Date    : 23/01/07
 * @Feature : Product의 메서드를 구현한다.
 **/

package factory.idcard;

import factory.framework.Product;

public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println(owner + "의 카드를 생성합니다.");
        this.owner = owner;
    }

    /**
     * toString()을 거쳐서 생성된 객체명을 출력한다.
     **/
    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    /**
     * toString()을 "[IDCard:owner]" 형식으로 재정의하는 메서드.
     **/
    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    /**
     * owner를 반환하는 메서드.
     **/
    public String getOwner() {
        return owner;
    }
}

/*
    이 클래스는 '구체적인 제품(Concrete Product)' 역할을 수행한다.
    구체적인 제품은 제품을 구체적으로 구현한다.
*/