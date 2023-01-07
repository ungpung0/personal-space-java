/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : Print의 메서드를 실행한다.
 **/

package adapter;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();
    }
}

/*
 *  이 클래스는 '고객(Client)' 역할을 맡는다.
 *  고객은 대상(Target)의 메서드를 실행한다.
 */