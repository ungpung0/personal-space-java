/**
 * @Author : ungpung0
 * @Date    : 23/01/08
 * @Feature : 연습문제 풀이 1, 티켓을 싱글턴 방식으로 제공하는 클래스.
 **/

package singleton.practiece;

public class TicketMaker {
    private int ticket;

    private static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {}

    /**
     * ticketMaker 인스턴스를 반환하는 메서드.
     **/
    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    /**
     * ticket을 1 증가시키는 동기화 메서드.
     **/
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}

/*
    synchronized는 멀티스레드 환경에서 동기화 문제를 해결하기 위해서 사용한다.
    synchronized 키워드를 변수와 메서드에 붙일 경우, 사용중인 스레드를 제외하면 데이터에 접근할 수 없다.
    남발할경우 block과 unblock 처리가 많아져서 성능 저하가 일어날 수 있는 것을 명심하자.
*/