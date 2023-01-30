/**
 * @Author : ungpung0
 * @Date    : 23/01/30
 * @Feature : 금고 상태의 변화를 관리하고 경비 센터와 연락하는 인터페이스.
 **/

package state;

public interface Context {
    public abstract void setClock(int hour);

    public abstract void changeState(State state);

    public abstract void callSecurityCenter(String message);

    public abstract void recordLog(String message);
}

/*
    이 인터페이스는 Context(문맥) 역할을 수행한다.
    Context 인터페이스는 State 사용자에게 필요한 API를 정의한다.
 */