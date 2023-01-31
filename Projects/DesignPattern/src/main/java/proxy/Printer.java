/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 이름 붙인 프린터를 나타내는 클래스. (본인)
 **/

package proxy;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Printer 인스턴스 생성중");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스(" + name + ") 생성중");
    }

    /**
     * 프린터 이름을 설정하는 메서드.
     * @param name
     *          프린터 이름
     */
    @Override
    public void setPrinterName(String name) {
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
     * @param string
     *          프린터 내용
     */
    @Override
    public void print(String string) {
        System.out.println("=====" + name + "=====");
        System.out.println(string);
    }

    /**
     * Proxy가 처리할 수 없는 무거운 작업을 나타내는 메서드.
     * @param message
     *          출력 메시지
     */
    private void heavyJob(String message) {
        System.out.print(message);

        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {

            }
            System.out.print(".");
        }
        System.out.println("완료");
    }
}

/*
    이 클래스는 RealSubject(실제 본인) 역할을 수행한다.
    RealSubject는 Proxy로는 할 수 없는 무거운 작업들을 맡는다.
 */
