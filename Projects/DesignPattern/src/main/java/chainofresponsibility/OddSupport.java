/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 트러블을 해결하는 구상 클래스. (홀수 번호 트러블 해결)
 **/

package chainofresponsibility;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    /**
     * 트러블을 처리하는 메서드.
     * trouble의 number가 홀수일 경우 true를 반환한다.
     * @param trouble
     *          해결할 문제
     */
    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1) {
            return true;
        }else {
            return false;
        }
    }
}

/*
    이 클래스는 Concrete Handler(구체적인 처리자) 역할을 수행한다.
    Concrete Handler는 Handler를 구체적으로 구현한다.
 */
