/**
 * @Author : ungpung0
 * @Date    : 23/01/30
 * @Feature : State를 구현하여 야간 상태를 나타낸다.
 **/

package state;

public class NightState implements State {
    private static NightState nightState = new NightState();

    private NightState() {}

    /**
     * 싱글턴 방식의 객체를 반환하는 메서드.
     **/
    public static State getInstance() {
        return nightState;
    }

    /**
     * 시간을 설정하는 메서드.
     * @param context
     *          Context API
     * @param hour
     *          시간
     **/
    @Override
    public void doClock(Context context, int hour) {
        if(hour >= 9 && hour < 17)
            context.changeState(DayState.getInstance());
    }

    /**
     * 금고 사용 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상: 야간 금고 사용!");
    }

    /**
     * 비상벨 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");
    }

    /**
     * 전화 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doPhone(Context context) {
        context.recordLog("야간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야간]";
    }
}

/*
    이 클래스는 Concrete State(구체적인 상태) 역할을 수행한다.
    Concrete State는 State를 구체적으로 구현한다.
 */