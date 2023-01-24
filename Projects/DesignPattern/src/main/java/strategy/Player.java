/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 구현한 전략(Strategy)를 사용하여 가위바위보를 수행한다.
 **/

package strategy;

public class Player {
    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }

    /**
     * 승부에서 이겼을 때 필요한 메서드를 호출하는 메서드.
     **/
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    /**
     * 승부에서 졌을 때 필요한 메서드를 호출하는 메서드.
     **/
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    /**
     * 승부에서 비겼을 때 게임 횟수를 증가시키는 메서드.
     **/
    public void draw() {
        gameCount++;
    }

    @Override
    public String toString() {
        return "["
                + name + ":"
                + gameCount + " games, "
                + winCount + " win,"
                + loseCount + " lose"
                + "]";
    }
}

/*
    이 클래스는 '문맥(Context)' 역할을 수행한다.
    문맥 클래스는 '전략(Strategy)'를 호출하여 '구체적인 전략(Concrete Strategy)' 인스턴스를 생성하고 사용한다.
 */
