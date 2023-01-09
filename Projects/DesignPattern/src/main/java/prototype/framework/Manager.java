/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : Product 인스턴스를 복사하여 새로운 인스턴스를 생성한다.
 **/

package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    /**
     * 맵에 키(name)를 갖는 Product(prototype)를 생성하는 메서드.
     * @param name
     *          인스턴스명.
     * @param prototype
     *          Product명.
     **/
    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    /**
     * 맵의 해당 이름(prototypeName)의 인스턴스를 가져와 복사, 반환하는 메서드.
     * @param prototypeName
     *          복사할 인스턴스명.
     **/
    public Product create(String prototypeName) {
        Product product = showcase.get(prototypeName);
        return product.createCopy();
    }
}

/*
    이 클래스는 사용자(Client) 역할을 맡는다.
    사용자 클래스는 구현한 인스턴스를 복사하여 새로운 인스턴스를 생성한다.
 */
