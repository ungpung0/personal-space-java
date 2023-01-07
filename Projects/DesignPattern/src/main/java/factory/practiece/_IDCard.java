/**
 * @Author : ungpung0
 * @Date    : 23/01/07
 * @Feature : 일련번호를 추가하는 연습문제.
 **/

package factory.practiece;

import factory.framework.Product;

public class _IDCard extends Product {
    private String owner;
    private int number;

    _IDCard(String owner, int number) {
        System.out.println(owner + "의 카드를 일련번호(" + number + ")로 생성합니다.");
        this.owner = owner;
        this.number = number;
    }

    /**
     * toString()을 거쳐서 생성된 객체명을 출력한다.
     **/
    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    /**
     * toString()을 "[IDCard:owner(number)]" 형식으로 재정의하는 메서드.
     **/
    @Override
    public String toString() {
        return "[IDCard:" + owner + "(" + number + ")]";
    }

    /**
     * owner를 반환하는 메서드.
     **/
    public String getOwner() {
        return owner;
    }

    /**
     * number를 반환하는 메서드.
     **/
    public int getNumber() {
        return number;
    }
}

/*
    이 클래스는 '구체적인 제품(Concrete Product)' 역할을 수행한다.
    구체적인 제품은 제품을 구체적으로 구현한다.
*/