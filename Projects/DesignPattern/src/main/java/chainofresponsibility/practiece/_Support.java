/**
 * @Author  : ungpung0
 * @Date    : 23/01/27
 * @Feature : 연습 문제, doSupport()를 루프로 전개.
 **/

package chainofresponsibility.practiece;

import chainofresponsibility.Trouble;

public abstract class _Support {
    private String name;
    private _Support next;

    public _Support(String name) {
        this.name = name;
        this.next = null;
    }

    public _Support setNext(_Support next) {
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
        for(_Support object = this; true; object = object.next) {
            if(object.resolve(trouble)) {
                object.success(trouble);
                break;
            }else if(object.next == null) {
                object.failed(trouble);
                break;
            }
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
