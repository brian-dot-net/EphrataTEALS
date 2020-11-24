
// BLACKJACK programmed by Brian Rogers.
// For rules, see `printHelp`.
import java.util.Scanner;

public class Blackjack {
    // Prints the help screen, explaining the rules of the game.
    public static void printHelp() {
        System.out.println("OBJECT");
        System.out.println("Beat the dealer by having a higher value hand without going over 21.");
        System.out.println();
        System.out.println("GAME PLAY");
        System.out.println("The round starts by dealing 2 cards each to the player and the dealer.");
        System.out.println("The dealer's first card is hidden, while the second card is face up.");
        System.out.println("The player can either request another card ('hit') or stay with the");
        System.out.println("current hand ('stand').");
        System.out.println("The player can hit as long as the total hand value is below 21.");
        System.out.println("Once the player stands, the dealer plays.");
        System.out.println("The dealer always hits on 16 and stands on 17.");
        System.out.println();
        System.out.println("CARD VALUES");
        System.out.println("Aces are worth either 1 or 11. Face cards are worth 10.");
        System.out.println("All other cards are worth their face value.");
        System.out.println();
        System.out.println("WINNING AND LOSING");
        System.out.println("The player 'busts' and loses the round if the value goes above 21.");
        System.out.println("It is an automatic win if the player's hand has six cards without busting.");
        System.out.println("It is a tie ('push') if the dealer and player have the same hand value.");
        System.out.println("Otherwise, the higher value hand wins.");
        System.out.println();
        System.out.println("BLACKJACK");
        System.out.println("A hand containing any 10 card (J, Q, K, T) and an ace is called a 'natural 21'");
        System.out.println("or 'blackjack'.");
        System.out.println("If the dealer has blackjack, the player automatically loses unless the player");
        System.out.println("also has blackjack (in which case, it is a push).");
        System.out.println();
        System.out.println("BETTING");
        System.out.println("Before the deal, the player bets any whole amount between 1 and the total money.");
        System.out.println("A winning hand wins the bet amount; a push gives the money back.");
        System.out.println("The game is over when the money is gone.");
        System.out.println();
    }

    // Entry point
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        runIntro(console);
        playGame(console);
        System.out.println("Thanks for playing. Better luck next time!");
        console.close();
    }

    // Prints the title screen and optionally the help screen
    public static void runIntro(Scanner console) {
        System.out.println("[B][L][A][C][K][J][A][C][K]");
        System.out.println();
        if (promptYesNo(console, "Do you want help?")) {
            printHelp();
        }
    }

    // Ask the user for a yes/no answer ("y" or "n") and return it as a boolean
    // ("y" -> true).
    // We use an infinite loop here to ensure we never return until the input is
    // found!
    public static boolean promptYesNo(Scanner console, String text) {
        while (true) {
            System.out.print(text + " (y/n) ");
            String response = console.next();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            }
        }
    }

    // Main game loop.
    public static void playGame(Scanner console) {
        int money = 100;
        String deck = "";
        int numberOfDecks = 2;
        while (money > 0) {
            if (deck.length() < 20) {
                System.out.println("Shuffling...");
                deck = initializeDeck(numberOfDecks);
            }

            System.out.println("TODO: " + deck);

            int bet = requestBet(console, money);
            System.out.println("TODO: $" + bet);
        }
    }

    // Initializes the cards using the specified number of decks.
    // Each deck is the standard 52-card size (4 each of A-K).
    public static String initializeDeck(int number) {
        String deck = "";
        for (int i = number * 4; i > 0; i--) {
            deck += "A23456789TJQK";
        }

        return deck;
    }

    // Request the player's bet.
    // The infinite loop will only return if the bet is valid.
    public static int requestBet(Scanner console, int money) {
        System.out.println("You have $" + money + ".");
        while (true) {
            System.out.print("Enter your bet: $");
            int bet = console.nextInt();
            if (bet > money) {
                System.out.println("You don't have enough money for that!");
            } else if (bet <= 0) {
                System.out.println("Serious bets only, please!");
            } else {
                return bet;
            }
        }
    }
}