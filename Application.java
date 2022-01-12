import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<String> list = new ArrayList<>();

    public static void playerVersusComputer() {
        Scanner scan = new Scanner(System.in);
        String value = "";

        Player player1 = new Player();
        Computer computer = new Computer();

        player1.setName("Player 1");

        System.out.println("Hi " + player1.getName() + " , Please enter any of - ROCK, PAPER, SCISSORS");

        value = scan.next();

        while (!value.equalsIgnoreCase("ROCK") && !value.equalsIgnoreCase("PAPER") && !value.equalsIgnoreCase("SCISSORS")) {
            System.out.println("Invalid value, enter any of ROCK, PAPER, SCISSORS ");
            value = scan.next();
        }

        player1.setValue(value);
        computer.setValue();
        computer.setName("Computer");

        System.out.println("Computer's value is - " + computer.getValue() + "\n");

        if (player1.getValue().equalsIgnoreCase(computer.getValue())) {
            System.out.println("Game is Draw");
            list.add("Game is draw");
        } else {
            Player winner = new Winner().play(player1, computer);
            list.add("The winner is - " + winner.getName());
            System.out.println("The winner is - " + winner.getName());
        }

    }

    public static void playerVersusPlayer() {
        Scanner scan = new Scanner(System.in);
        String value = "";

        Player player1 = new Player();
        Player player2 = new Player();

        player1.setName("Player 1");

        player2.setName("Player 2");

        System.out.println("Rock, Paper, Scissors\n");

        System.out.println("Hi " + player1.getName() + " , Please enter any values - ROCK, PAPER, SCISSORS");

        value = scan.next();

        while (!value.equalsIgnoreCase("ROCK") && !value.equalsIgnoreCase("PAPER") && !value.equalsIgnoreCase("SCISSORS")) {
            System.out.println("Invalid value, enter any of ROCK, PAPER, SCISSORS ");
            value = scan.next();
        }

        player1.setValue(value);


        System.out.println("Hi " + player2.getName() + " , Please enter any values - ROCK, PAPER, SCISSORS\n");

        value = scan.next();

        while (!value.equalsIgnoreCase("ROCK") && !value.equalsIgnoreCase("PAPER") && !value.equalsIgnoreCase("SCISSORS")) {
            System.out.println("Invalid value, enter any of ROCK, PAPER, SCISSORS ");
            value = scan.next();
        }

        player2.setValue(value);

        if (player1.getValue().equalsIgnoreCase(player2.getValue())) {
            System.out.println("Game is draw");
            list.add("Game is draw");
        } else {
            Player winner = new Winner().play(player1, player2);

            System.out.println("The winner is - " + winner.getName());
            list.add("The winner is - " + winner.getName());
        }

    }

    public static void menu() {
        System.out.println("\n\nWelcome to Rock, Paper, Scissors!");
        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.");
    }

    public static void main(String[] args) {

        boolean isActive = true;
        Scanner input = new Scanner(System.in);
        while (isActive) {
            menu();
            String in = input.next();
            if (in.equalsIgnoreCase("play")) {
                System.out.println("Please choose\nType 1 for player vs player\nType 2 for player vs computer");
                boolean isGood = true;
                while (isGood) {
                    int c = input.nextInt();
                    switch (c) {
                        case 1:
                            playerVersusPlayer();
                            isGood = false;
                            break;
                        case 2:
                            playerVersusComputer();
                            isGood = false;
                            break;
                        default:
                            System.out.println("Please enter 1 or 2");
                    }
                }

            } else if (in.equalsIgnoreCase("history")) {
                System.out.println("====");
                System.out.println("The History");
                list.forEach(item -> System.out.println(item));
            } else if (in.equalsIgnoreCase("quit")) {
                isActive = false;
                System.out.println("Thank you!");
            } else {
                System.out.println("Please enter a valid input");
            }

        }
        input.close();
    }
}
