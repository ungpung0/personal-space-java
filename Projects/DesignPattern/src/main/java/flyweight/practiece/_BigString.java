/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 연습 문제 풀이, 공유 여부에 따라서 생성자를 분리한다.
 **/

package flyweight.practiece;

import flyweight.BigChar;
import flyweight.BigCharFactory;

public class _BigString {
    private BigChar[] bigChars;
    public _BigString(String string) {
        initShared(string);
    }

    public _BigString(String string, boolean shared) {
        if(shared)
            initShared(string);
        else
            initUnShared(string);
    }

    /**
     * 자원을 공유할 때, BigCharFactory를 경유하여 인스턴스를 가져오는 메서드.
     * @param string
     *          문자열
     */
    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigChars = new BigChar[string.length()];
        for(int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    /**
     * 자원을 공유하지 않을 때, BigChar를 매번 생성하는 메서드.
     * @param string
     *          문자열
     */
    private void initUnShared(String string) {
        bigChars = new BigChar[string.length()];
        for(int i = 0; i < bigChars.length; i++) {
            bigChars[i] = new BigChar(string.charAt(i));
        }
    }

    /**
     * 배열에 저장된 인스턴스를 출력하는 메서드.
     * BigChar의 print()를 사용한다.
     */
    public void print() {
        for(BigChar bc : bigChars) {
            bc.print();
        }
    }
}

/*
    이 클래스는 Client(의뢰자) 역할을 수행한다.
    Client는 FlyWeight Factory를 사용하여 FlyWeight 인스턴스를 활용한다.
 */
