/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package facade;

import facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
    }
}

/*
    이 클래스는 Client(외뢰자) 역할을 수행한다.
    Client는 Facade를 호출하여 프로그램을 실행한다.
 */