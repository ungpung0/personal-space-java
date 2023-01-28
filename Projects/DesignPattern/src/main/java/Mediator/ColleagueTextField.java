/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : Colleague를 구현하여 텍스트를 나타내는 클래스.
 **/

package Mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
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
     * 활성화 여부에 따라서 텍스트 필드 색상을 변경한다.
     * @param enabled
     *          활성화 여부
     */
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.BLACK);
    }

    /**
     * 텍스트 상태가 변화하면 Mediator에게 알리는 메서드.
     * @param e
     *          텍스트 이벤트
     */
    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}

/*
    이 클래스는 Concrete Colleague(구체적인 동료) 역할을 수행한다.
    Concrete Colleague는 Colleague의 API를 실제로 구현한다.
 */