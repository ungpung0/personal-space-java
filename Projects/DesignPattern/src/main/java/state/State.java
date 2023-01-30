/**
 * @Author : ungpung0
 * @Date    : 23/01/30
 * @Feature : 금고 상태를 나타내는 인터페이스.
 **/

package state;

public interface State {
    public abstract void doClock(Context context, int hour);

    public abstract void doUse(Context context);

    public abstract void doAlarm(Context context);

    public abstract void doPhone(Context context);
}

/*
    이 인터페이스는 State(상태) 역할을 수행한다.
    State는 상태에 따라 동작하는 메서드를 한 곳에서 정의한다.
 */
