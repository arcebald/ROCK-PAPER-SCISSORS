public class Winner {

    private Player winner;

    public Player play(Player player1, Player player2) {

        String value1 = player1.getValue();
        String value2 = player2.getValue();

        if (value1.equalsIgnoreCase("ROCK")) {
            this.winner = value2.equalsIgnoreCase("SCISSORS") ? player1 : player2;
        } else if (value1.equalsIgnoreCase("PAPER")) {
            this.winner = value2.equalsIgnoreCase("ROCK") ? player1 : player2;
        } else {
            this.winner = value2.equalsIgnoreCase("PAPER") ? player1 : player2;
        }
        return this.winner;

    }

}
