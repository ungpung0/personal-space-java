/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : Printer와 PrinterProxy의 공통 인터페이스.
 **/

package proxy;

public interface Printable {
    public abstract void setPrinterName(String name);

    public abstract String getPrinterName();

    public abstract void print(String string);
}

/*
    이 인터페이스는 Subject(본인) 역할을 수행한다.
    Subject는 Proxy와 RealSubject를 동일하게 다루는 API를 제공한다.
 */
