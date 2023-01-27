/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 트러블을 해결하는 구상 클래스. (특정 번호 트러블 해결)
 **/


package chainofresponsibility;

public class SpecialSupport extends Support {
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    /**
     * 트러블을 처리하는 메서드.
     * trouble의 number가 일치할 경우 true를 반환한다.
     * @param trouble
     *          해결할 문제
     */
    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() == number) {
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