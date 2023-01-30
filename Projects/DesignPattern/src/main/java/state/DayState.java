/**
 * @Author : ungpung0
 * @Date    : 23/01/30
 * @Feature : State를 구현하여 주간 상태를 나타낸다.
 **/

package state;

public class DayState implements State {
    private static DayState dayState = new DayState();

    private DayState() {}

    /**
     * 싱글턴 방식의 객체를 반환하는 메서드.
     **/
    public static State getInstance() {
        return dayState;
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
        if(hour < 9 || hour >= 17)
            context.changeState(NightState.getInstance());
    }

    /**
     * 금고 사용 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(주간)");
    }

    /**
     * 비상벨 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    /**
     * 전화 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}

/*
    이 클래스는 Concrete State(구체적인 상태) 역할을 수행한다.
    Concrete State는 State를 구체적으로 구현한다.
 */