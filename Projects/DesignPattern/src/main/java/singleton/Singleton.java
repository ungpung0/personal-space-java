/**
 * @Author : ungpung0
 * @Date    : 23/01/08
 * @Feature : 싱글턴 방식으로 인스턴스를 제공하는 클래스.
 **/

package singleton;

public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    /**
     * 외부에서 생성된 인스턴스에 접근할 수 있는 유일한 통로 역할 메서드.
     **/
    public static Singleton getInstance() {
        return singleton;
    }
}

/*
    이 클래스는 싱글턴(Singleton) 역할을 맡는다.
    싱글턴은 자체적으로 인스턴스를 생성하며(Static), 타 클래스에서 별도로 생성을 할 수 없다(private).
*/
