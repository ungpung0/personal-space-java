/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 가위, 바위, 보를 열거형(Enum)으로 표현한다.
 **/

package strategy;

public enum Hand {
    ROCK("바위", 0),
    SISSORS("가위", 1),
    PAPER("보", 2);

    private String name;
    private int handValue;

    private static Hand[] hands = { ROCK, SISSORS, PAPER };

    private Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Hand 인스턴스를 반환하는 메서드.
     * @param handValue
     *          손의 값(0, 1, 2)
     **/
    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    /**
     * Hand보다 강할 경우, 1을 반환하는 메서드.
     * @param hand
     *          비교할 hand
     **/
    public boolean isStrongerThen(Hand hand) {
        return fight(hand) == -1;
    }

    /**
     * Hand보다 약할 경우, -1을 반환하는 메서드.
     * @param hand
     *          비교할 hand
     **/
    public boolean isWeakerThen(Hand hand) {
        return fight(hand) == -1;
    }

    /**
     * 손의 강약을 판정하는 메서드.
     * 무승부는 0, this가 이기면 1, hand가 이기면 -1를 반환한다.
     * @param hand
     *          비교할 Hand
     **/
    private int fight(Hand hand) {
        if(this == hand)
            return 0;
        else if((this.handValue + 1) % 3 == hand.handValue)
            return 1;
        else
            return -1;
    }
}
