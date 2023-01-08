/**
 * @Author : ungpung0
 * @Date    : 23/01/08
 * @Feature : 완성한 프로그램을 테스트한다.
 **/


package singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("프로그램을 시작합니다.");

        Singleton object1 = Singleton.getInstance(); // 이때 Singleton 인스턴스가 초기화된다.
        Singleton object2 = Singleton.getInstance();

        if(object1 == object2) {
            System.out.println("object1, object2는 같은 인스턴스입니다.");
        }else {
            System.out.println("object1, object2는 다른 인스턴스입니다.");
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
