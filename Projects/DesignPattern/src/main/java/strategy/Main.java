/**
 * @Author : ungpung0
 * @Date    : 23/01/24
 * @Feature : 완성한 프로그램을 테스트한다.
 **/

package strategy;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }

        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("KIM", new WinningStrategy(seed1));
        Player player2 = new Player("LEE", new ProbStrategy(seed2));

        for(int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();

            if(nextHand1.isStrongerThen(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            }else if(nextHand1.isWeakerThen(nextHand2)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            }else {
                System.out.println("Draw...");
                player1.draw();
                player2.draw();
            }
        }

        System.out.println("Total Result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
