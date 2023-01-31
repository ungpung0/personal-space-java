/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 연습 문제 풀이, State를 구현하여 점심 상태를 나타낸다.
 **/

package state.practiece;

import state.Context;
import state.State;

public class EmerState implements State {
    private static EmerState emerState = new EmerState();

    private EmerState() {}

    /**
     * 싱글턴 방식의 객체를 반환하는 메서드.
     **/
    public static State getInstance() {
        return emerState;
    }

    /**
     * 시간을 설정하는 메서드. (작동하지 않음)
     * @param context
     *          Context API
     * @param hour
     *          시간
     **/
    @Override
    public void doClock(Context context, int hour) {

    }

    /**
     * 금고 사용 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(비상)");
    }

    /**
     * 비상벨 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(비상)");
    }

    /**
     * 전화 메시지를 전달하는 메서드.
     * @param context
     *          Context API
     **/
    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(비상)");
    }

    @Override
    public String toString() {
        return "[비상]";
    }
}

/*
    이 클래스는 Concrete State(구체적인 상태) 역할을 수행한다.
    Concrete State는 State를 구체적으로 구현한다.
 */