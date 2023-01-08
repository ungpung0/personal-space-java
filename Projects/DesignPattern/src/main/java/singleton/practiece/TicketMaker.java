/**
 * @Author : ungpung0
 * @Date    : 23/01/08
 * @Feature : 싱글턴 방식으로 인스턴스를 제공하는 클래스.
 **/

package singleton.practiece;

public class TicketMaker {
    private int ticket;

    private static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {}

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
