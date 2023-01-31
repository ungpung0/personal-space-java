/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : BigChar를 모아서 큰 문자열을 나타내는 클래스.
 **/

package flyweight;

public class BigString {
    private BigChar[] bigChars;

    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigChars = new BigChar[string.length()];
        for(int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
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
