/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 연습 문제 풀이, 과거 승부와 관계없이 무작위로 다음 수를 반환한다.
 **/

package strategy.practiece;

import strategy.Hand;
import strategy.Strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    /**
     * 다음 차례의 Hand를 반환하는 메서드.
     **/
    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {

    }
}
