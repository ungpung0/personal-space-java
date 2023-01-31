/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : BigChar 인스턴스를 공유하여 생성하는 클래스.
 **/

package flyweight;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    private Map<String, BigChar> pool = new HashMap<>();
    private static BigCharFactory factory = new BigCharFactory();

    private BigCharFactory() {}

    /**
     * 싱글턴 방식의 BigCharFactory 인스턴스를 반환하는 메서드.
     **/
    public static BigCharFactory getInstance() {
        return factory;
    }

    /**
     * BigChar 인스턴스를 생성하고 공유하는 메서드.
     * 인스턴스가 비어있을 경우 생성한뒤 반환한다.
     * @param charname
     *          문자 이름
     */
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get(String.valueOf(charname));
        if(bc == null) {
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
    }
}

/*
    이 클래스는 FlyWeight Factory(플라이급 공장) 역할을 수행한다.
    FlyWeight Factory는 FlyWeight 인스턴스를 생성해서 공유한다.
 */
