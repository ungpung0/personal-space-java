/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : 연습문제 풀이 2, Cloneable()를 구현하지 않는다.
 **/

package prototype.practiece;

public interface _Product {
    public abstract void use(String string);

    public abstract _Product createCopy();

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
