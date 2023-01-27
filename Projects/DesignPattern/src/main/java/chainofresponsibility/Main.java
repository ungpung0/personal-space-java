/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        for(int i = 0; i < 500; i += 33) {
            alice.doSupport(new Trouble(i));
        }
    }
}

/*
    이 클래스는 Client(요구자) 역할을 수행한다.
    Client는 문제를 해결하기 위해 Handler를 요청한다.
 */
