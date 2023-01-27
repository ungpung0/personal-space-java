/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 트러블을 해결하는 구상 클래스. (항상 해결하지 않음)
 **/

package chainofresponsibility;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    /**
     * 트러블을 처리하는 메서드.
     * 언제나 false를 반환한다.
     * @param trouble
     *          해결할 문제
     */
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}

/*
    이 클래스는 Concrete Handler(구체적인 처리자) 역할을 수행한다.
    Concrete Handler는 Handler를 구체적으로 구현한다.
 */
