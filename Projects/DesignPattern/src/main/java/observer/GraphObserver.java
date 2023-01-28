/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 관측한 수를 그래프의 형태로 표시하는 클래스.
 **/

package observer;

public class GraphObserver implements Observer {

    /**
     * 관찰한 결과를 그래프로 출력하는 메서드.
     * @param generator
     *          숫자를 생성하는 NumberGenerator
     **/
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver:");
        int count = generator.getNumber();
        for(int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
    이 클래스는 Concrete Observer(구체적인 관찰자) 역할을 수행한다.
    Concrete Observer는 Observer의 메서드를 구현하여 Subject의 상태를 활용한다.
 */