/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : Colleague를 구현하여 버튼을 나타내는 클래스.
 **/

package Mediator;

import java.awt.*;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    /**
     * Mediator를 설정하는 메서드.
     * @param mediator
     *          Mediator
     */
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Mediator에서 활성화 여부를 지시하는 메서드.
     * @param enabled
     *          활성화 여부
     */
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}

/*
    이 클래스는 Concrete Colleague(구체적인 동료) 역할을 수행한다.
    Concrete Colleague는 Colleague의 API를 실제로 구현한다.
 */