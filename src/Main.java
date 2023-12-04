public class Main {
    public static void main(String[] args) {

        int winsToPlayUntil = 3;
        Game game = new Game(winsToPlayUntil, new Player(), new Player());

        while (!game.isFinished()) {
            Turn turn = game.playTurn();
            System.out.println(turn);
            System.out.println("\n");
            System.out.println(game);
            System.out.println("\n");
        }
        System.out.printf("%d VOITTOA - PELI PÄÄTTYY", winsToPlayUntil);
    }
}