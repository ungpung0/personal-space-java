/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 이전 승부 결과에 따라서 다음에 가위바위보 전략(Strategy)을 구현한다.
 **/

package strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    /**
     * 다음 차례의 Hand를 반환하는 메서드.
     * Hand는 이전 승부(won)의 값이 true면 그대로, false면 난수를 사용하여 결정한다.
     **/
    @Override
    public Hand nextHand() {
        if(!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    /**
     * 이전 차례의 승패에 따라서 다음 수를 학습하는 메서드.
     * 승부 결과를 바탕으로 won 내용을 갱신한다.
     * @param win
     *          이전 승부 결과
     **/
    @Override
    public void study(boolean win) {
        won = win;
    }
}

/*
    이 클래스는 '구체적인 전략(Concrete Strategy)' 역할을 수행한다.
    전략(Strategy) API를 구체저으로 구현한다.
 */
