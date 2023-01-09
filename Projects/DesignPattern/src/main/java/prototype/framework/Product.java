/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : UnderlinePen, MessageBox에서 구현되고 Manager에서 호출될 메서드를 결정한다.
 **/

package prototype.framework;

public interface Product extends Cloneable {
    public abstract void use(String string);

    public abstract Product createCopy();

    /**
     * 문자를 길이만큼 반복해서 출력하는 익명 메서드.
     * @param length
     *          문자열의 길이.
     * @param decoChar
     *          반복할 문자.
     **/
    public default void print(int length, char decoChar) {
        for(int i = 0; i < length; i++) {
            System.out.print(decoChar);
        }
        System.out.println();
    }
}

/*
    이 인터페이스는 원형(Prototype) 역할을 맡는다.
    원형 인터페이스는 인스턴스를 복사하기 위한 메소드를 결정한다.

    clone을 사용하여 인스턴스를 복사하기 위해서, 복사대상은 반드시 java.lang.Cloneable 인터페이스를 구현해야만 한다.
    구현이 끝난 클래스의 인스턴스는 clone()을 호출하여 복사하며, 구현하지 않은 클래스를 복사하면 CloneNotSupportedException이 발생한다.
    clone()은 참조를 복사하는 얕은 복사(Shallow Copy)를 수행하며, 충분하지 않으면 직접 clone()을 오버라이딩 할 수 있다.
 */