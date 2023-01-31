/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 이름 붙인 프린터를 나타내는 클래스. (대리인)
 **/

package proxy;

public class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy() {
        name = "No Name";
        real = null;

    }

    public PrinterProxy(String name) {
        this.name = name;
        real = null;
    }

    /**
     * 프린터 이름을 설정하는 메서드.
     * Printer가 이름이 null이면 설정한다.
     * @param name
     *          프린터 이름
     */
    @Override
    public synchronized void setPrinterName(String name) {
        if(real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    /**
     * 프린터 이름을 반환하는 메서드.
     */
    @Override
    public String getPrinterName() {
        return name;
    }

    /**
     * 프린터 이름과 내용을 출력하는 메서드.
     * 먼저, realize()로 Printer 인스턴스 생성 여부를 확인한다.
     * @param string
     *          프린터 내용
     */
    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    /**
     * Printer 인스턴스가 존재하지 않으면 생성하는 메서드.
     */
    private synchronized void realize() {
        if(real == null)
            real = new Printer(name);
    }
}

/*
    이 클래스는 Proxy(대리인) 역할을 수행한다.
    Proxy는 Client의 요청을 최대한 처리하되, 불가능한 일은 RealSubject로 일임한다.
 */
