/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package proxy;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.setPrinterName("Bob");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.print("Hello, World.");
    }
}

/*
    이 클래스는 Client(의뢰인) 역할을 수행한다.
    Client는 Proxy 패턴을 사용하여 프로그램을 실행한다.
 */
