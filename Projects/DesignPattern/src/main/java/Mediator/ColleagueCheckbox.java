/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : Colleague를 구현하여 체크박스를 나타내는 클래스.
 **/

package Mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
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

    /**
     * 체크박스 상태가 변화하면 Mediator에게 알리는 메서드.
     * @param e
     *          아이템 이벤트
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}

/*
    이 클래스는 Concrete Colleague(구체적인 동료) 역할을 수행한다.
    Concrete Colleague는 Colleague의 API를 실제로 구현한다.
 */