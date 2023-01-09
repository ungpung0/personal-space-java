/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : Product를 구현한다.
 **/

package prototype;

import prototype.framework.Product;

public class UnderlinePen implements Product {
    private char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }

    /**
     * string에 문자로된 밑줄을 추가하여 출력하는 메서드.
     * @param string
     *          출력할 문자열.
     **/
    @Override
    public void use(String string) {
        int ulLength = string.length();
        System.out.println(string);
        print(ulLength, ulChar);
    }

    /**
     * 새로운 Product를 반환하는 메서드.
     **/
    @Override
    public Product createCopy() {
        Product product = null;
        try {
            product = (Product) clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}

/*
    이 클래스는 구체적인 원형(Concrete Prototype) 역할을 맡는다.
    구체적인 원형 클래스는 원형 인터페이스를 구현하여 인스턴스의 메서드를 구체화한다.
 */
