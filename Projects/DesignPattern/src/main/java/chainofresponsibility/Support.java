/**
 * @Author  : ungpung0
 * @Date    : 23/01/27
 * @Feature : 트러블을 해결하는 추상 클래스.
 **/

package chainofresponsibility;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }
    /**
     * 트러블을 처리하기 위해 메서드를 호출하는 메서드.
     * 문제 해결 여부에 따라서 특정 메서드를 호출한다.
     * @param trouble
     *          해결할 문제
     */
    public void doSupport(Trouble trouble) {
        if(resolve(trouble)) {
            success(trouble);
        }else if(next != null) {
            next.doSupport(trouble);
        }else {
            failed(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble);

    /**
     * 해결을 성공했을 때 결과를 출력하는 메서드.
     * @param trouble
     *          해결할 문제
     */
    protected void success(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    /**
     * 해결을 실패했을 때 결과를 출력하는 메서드.
     * @param trouble
     *          해결할 문제
     */
    protected void failed(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

/*
    이 추상 클래스는 Handler(처리자) 역할을 수행한다.
    Handler는 요구를 처리하는 API를 정의한다.
    만약 요구를 처리하지 못하면, 다음 Handler를 호출한다.
 */
