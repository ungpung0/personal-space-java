/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 트러블을 해결하는 구상 클래스. (지정 번호 미만 트러블 해결)
 **/

package chainofresponsibility;

public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    /**
     * 트러블을 처리하는 메서드.
     * trouble의 number가 limit 미만일 경우 true를 반환한다.
     * @param trouble
     *          해결할 문제
     */
    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit) {
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
