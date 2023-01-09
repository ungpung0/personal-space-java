/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : 연습문제 풀이 1, 인터페이스 Product를 추상 클래스로 변환하고, createCopy()를 정의한다.
 **/

package prototype.practiece;

public abstract class Product implements Cloneable {
    public abstract void use(String string);

    /**
     * 새로운 Product를 반환하는 메서드.
     **/
    public Product createCopy() {
        Product product = null;
        try {
            product = (Product) clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }

    /**
     * 문자를 길이만큼 반복해서 출력하는 메서드.
     * @param length
     *          문자열의 길이.
     * @param decoChar
     *          반복할 문자.
     **/
    public void print(int length, char decoChar) {
        for(int i = 0; i < length; i++) {
            System.out.print(decoChar);
        }
        System.out.println();
    }
}
