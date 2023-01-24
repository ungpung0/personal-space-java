/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 가위, 바위, 보 전략에 필요한 메서드를 결정한다.
 **/

package strategy;

public interface Strategy {
    /**
     * 다음 차례의 Hand를 반환하는 메서드.
     **/
    public abstract Hand nextHand();

    /**
     * 이전 차례의 승패에 따라서 다음 수를 학습하는 메서드.
     **/
    public abstract void study(boolean win);
}

/*
    이 인터페이스는 '전략(Strategy)' 역할을 수행한다.
    전략 패턴을 사용하기 위한 API를 결정한다.
 */
