/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : 연습문제 풀이 2, 복사생성자를 사용하여 _Product를 구현한다.
 **/

package prototype.practiece;

import prototype.framework.Product;

public class _MessageBox implements _Product {
    private char decoChar;

    public _MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    /**
     * 자신을 파라미터로 받을경우, decoChar를 복사하여 생성하는 생성자.
     **/
    public _MessageBox(_MessageBox prototype) {
        this.decoChar = prototype.decoChar;
    }

    /**
     * string을 메세지 박스 형태로 감싸서 출력하는 메서드.
     * @param string
     *          출력할 문자열.
     **/
    @Override
    public void use(String string) {
        int decoLength = string.length() + 2;
        print(decoLength, decoChar);
        System.out.println(decoChar + string + decoChar);
        print(decoLength, decoChar);
    }

    /**
     * 새로운 _Product를 반환하는 메서드.
     **/
    @Override
    public _Product createCopy() {
        return new _MessageBox(this);
    }
}

/*
    이 클래스는 구체적인 원형(Concrete Prototype) 역할을 맡는다.
    구체적인 원형 클래스는 원형 인터페이스를 구현하여 인스턴스의 메서드를 구체화한다.
 */
