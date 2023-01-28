/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 중재자 API를 결정하는 인터페이스.
 **/

package Mediator;

public interface Mediator {
    public abstract void createColleague();

    public abstract void colleagueChanged();
}

/*
    이 인터페이스는 Mediator(중재자) 역할을 수행한다.
    Mediator는 Colleague와 통신 및 조정 API를 정의한다.
 */