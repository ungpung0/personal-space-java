/**
 * @Author : ungpung0
 * @Date    : 23/01/09
 * @Feature : 연습문제 풀이 2, 알파, 베타, 감마 인스턴스를 싱글턴으로 제공하는 클래스.
 **/

package singleton.practiece;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {
    private static Map<String, Triple> map = new HashMap<>();

    static {
        String[] names = {"ALPHA", "BETA", "GAMMA"};
        Arrays.stream(names).forEach(s -> map.put(s, new Triple(s)));
    }

    private String name;

    private Triple(String name) {
        System.out.println("인스턴스 " + name + "를 생성했습니다.");
        this.name = name;
    }

    /**
     * map을 통해 생성한 인스턴스를 제공하는 메서드.
     **/
    public static Triple getInstance(String name) {
        return map.get(name);
    }

    /**
     * 인스턴스명을 반환하는 메서드.
     **/
    @Override
    public String toString() {
        return this.name;
    }
}
