/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 과거 승률을 계산하여 다음에 가위바위보 전략(Strategy)을 구현한다.
 **/

package strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currHandValue = 0;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    /**
     * Hand의 과거 승률을 합산하여 반환하는 메서드.
     * @param handValue
     *          손의 값(0, 1, 2)
     **/
    private int getSum(int handValue) {
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            sum += history[handValue][i];
        }
        return sum;
    }

    /**
     * 다음 차례의 Hand를 반환하는 메서드.
     * 0부터 getSum()으로 구한 값까지의 난수를 계산하여 다음 Hand를 결정한다.
     **/
    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currHandValue));
        int handValue = 0;

        if(bet < history[currHandValue][0]) {
            handValue = 0;
        }else if(bet < history[currHandValue][0] + history[currHandValue][1]) {
            handValue = 1;
        }else {
            handValue = 2;
        }

        prevHandValue = currHandValue;
        currHandValue = handValue;
        return Hand.getHand(handValue);
    }

    /**
     * 이전 차례의 승패에 따라서 다음 수를 학습하는 메서드.
     * 승부 결과를 바탕으로 history 내용을 갱신한다.
     * @param win
     *          이전 승부 결과
     **/
    @Override
    public void study(boolean win) {
        if(win) {
            history[prevHandValue][currHandValue]++;
        }else {
            history[prevHandValue][(currHandValue + 1) % 3]++;
            history[prevHandValue][(currHandValue + 2) % 3]++;
        }
    }
}

/*
    이 클래스는 '구체적인 전략(Concrete Strategy)' 역할을 수행한다.
    전략(Strategy) API를 구체저으로 구현한다.
 */
