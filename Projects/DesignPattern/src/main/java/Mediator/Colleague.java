/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : 멤버 API를 결정하는 인터페이스.
 **/

package Mediator;

public interface Colleague {
    public abstract void setMediator(Mediator mediator);

    public abstract void setColleagueEnabled(boolean enabled);
}

/*
    이 인터페이스는 Colleague(동료) 역할을 수행한다.
    Colleague는 Mediator와 통신하는 API를 정의한다.
 */