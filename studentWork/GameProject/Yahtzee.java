// YAHTZEE programmed by Brian Rogers.
// For rules, see `printHelp`.
import java.util.Scanner;

public class Yahtzee {
    // Prints the help screen, explaining the rules of the game.
    public static void printHelp() {
        System.out.println("OBJECT");
        System.out.println("Get the highest possible score in 13 rounds.");
        System.out.println();
        System.out.println("GAME PLAY");
        System.out.println("Each round starts by rolling 5 dice.");
        System.out.println("Choose which dice to reroll; you may roll up to two more times.");
        System.out.println("At the end of the round, record your score in one of the free combinations.");
        System.out.println();
        System.out.println("SCORING");
        System.out.println("There are 13 scoring combinations, divided into 'upper' and 'lower' sections.");
        System.out.println();
        System.out.println("  UPPER SECTION");
        System.out.println("    Aces    total all 1's in your roll");
        System.out.println("    Twos    total all 2's in your roll");
        System.out.println("    Threes  total all 3's in your roll");
        System.out.println("    Fours   total all 4's in your roll");
        System.out.println("    Fives   total all 5's in your roll");
        System.out.println("    Sixes   total all 6's in your roll");
        System.out.println("* If the sum of the upper section is 63 or higher, score a 35 point bonus!");
        System.out.println();
        System.out.println("  LOWER SECTION");
        System.out.println("    3 of a kind     3 of the same die; total all dice");
        System.out.println("    4 of a kind     4 of the same die; total all dice");
        System.out.println("    Full House      3 of the same die plus another pair; 25 points");
        System.out.println("    Small Straight  4 consecutive numbers; 30 points");
        System.out.println("    Large Straight  5 consecutive numbers; 40 points");
        System.out.println("    Yahtzee         5 of the same die; 50 points");
        System.out.println("    Chance          no specific combination; total all dice");
        System.out.println("* For each Yahtzee you roll after the first, score a 100 point bonus!");
    }

    // Entry point
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        runIntro(console);
        int finalScore = playGame(console);
        System.out.println("Great game! Your final score was " + finalScore + ".");
        console.close();
    }

    // Prints the title screen and optionally the help screen
    public static void runIntro(Scanner console) {
        System.out.println("_      _  __   __  __  ______ _____ _____ _____");
        System.out.println("\\\\    // //\\\\  ||  ||    ||      // ||    ||");
        System.out.println(" \\\\__// //__\\\\ ||__||    ||     //  ||__  ||__");
        System.out.println("   ||   ||  || ||  ||    ||    //   ||    ||");
        System.out.println("   ||   ||  || ||  ||    ||   //___ ||___ ||___");
        System.out.println();
        if (promptYesNo(console, "Do you want help?")) {
            printHelp();
        }
    }

    // Ask the user for a yes/no answer ("y" or "n").
    // We use an infinite loop here to ensure we never return until the input is valid!
    public static boolean promptYesNo(Scanner console, String text) {
        while (true) {
            System.out.print(text + " (y/n) ");
            String response = console.next();
            if (response.equals("y")) {
                return true;
            }
            else if (response.equals("n")) {
                return false;
            }
        }
    }

    // Main game logic goes here; returns the grand total score at the end.
    public static int playGame(Scanner console) {
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println("Let's play Yahtzee!");

        // Upper section scoring combinations (-1 means free/not recorded)
        int up1 = -1;
        int up2 = -1;
        int up3 = -1;
        int up4 = -1;
        int up5 = -1;
        int up6 = -1;

        // Lower section scoring combinations (-1 means free/not recorded)
        int lw3 = -1;
        int lw4 = -1;
        int lwFull = -1;
        int lwSmall = -1;
        int lwLarge = -1;
        int lwYahtzee = -1;
        int lwChance = -1;
        int lwBonus = -1;

        int grandTotal;

        // Display the scoring table
        grandTotal = 0;
        printSeparator('=');
        grandTotal += printUpperSection(
            up1, up2, up3, up4, up5, up6);
        printSeparator('-');
        grandTotal += printLowerSection(lw3, lw4, lwFull, lwSmall, lwLarge, lwYahtzee, lwChance, lwBonus);
        printSeparator('-');
        printScoreRow("GRAND TOTAL", grandTotal);
        printSeparator('=');

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        return grandTotal;
    }

    // Prints a separator row for the scoring table, using the given symbol.
    public static void printSeparator(char symbol) {
        System.out.print("| ");
        for (int i = 0; i < 13; i++) {
            System.out.print(symbol);
        }

        System.out.print(" | ");
        for (int i = 0; i < 5; i++) {
            System.out.print(symbol);
        }

        System.out.println(" |");
    }

    // Prints a numeric row for the scoring table, using the given name and value.
    // A value < 0 indicates an unfilled entry. Returns the score value if positive,
    // 0 otherwise.
    public static int printScoreRow(String name, int value) {
        String str = "";
        if (value >= 0) {
            str += value;
        }
        else {
            value = 0;
        }

        printRow(name, str);
        return value;
    }

    // Prints a generic two-column row for the scoring table.
    public static void printRow(String col1, String col2) {
        System.out.print("| ");
        padRight(col1, 13);
        System.out.print(" | ");
        padLeft(col2, 5);
        System.out.println(" |");
    }

    // Pads the String value to the given width by printing spaces on the right side.
    // e.g., the value "Hello" with width 8 would print "Hello   " with 3 spaces on the right.
    public static void padRight(String value, int width) {
        System.out.print(value);
        pad(value, width);
    }

    // Pads the String value to the given width by printing spaces on the left side.
    // e.g., the value "Hello" with width 8 would print "   Hello" with 3 spaces on the left.
    public static void padLeft(String value, int width) {
        pad(value, width);
        System.out.print(value);
    }

    // Pads the String value by printing spaces on the left side.
    // This is a helper method for the other `padXyz` methods.
    public static void pad(String value, int width) {
        for (int i = width - value.length(); i > 0; i--) {
            System.out.print(' ');
        }
    }

    // Prints the upper section of the scoring table.
    public static int printUpperSection(int up1, int up2, int up3, int up4, int up5, int up6) {
        int total = 0;
        total += printScoreRow("Aces", up1);
        total += printScoreRow("Twos", up2);
        total += printScoreRow("Threes", up3);
        total += printScoreRow("Fours", up4);
        total += printScoreRow("Fives", up5);
        total += printScoreRow("Sixes", up6);
        
        int upBonus = 0;
        if (total >= 63) {
            upBonus = 35;
        }
        
        total += printScoreRow("BONUS", upBonus);
        return total;
    }
        
    public static int printLowerSection(int lw3, int lw4, int lwFull, int lwSmall, int lwLarge, int lwYahtzee, int lwChance, int lowBonus) {
        int total = 0;
        total += printScoreRow("3 of a kind", lw3);
        total += printScoreRow("4 of a kind", lw4);
        total += printScoreRow("Full House", lwFull);
        total += printScoreRow("Sm. Straight", lwSmall);
        total += printScoreRow("Lg. Straight", lwLarge);
        total += printScoreRow("YAHTZEE", lwYahtzee);
        total += printScoreRow("Chance", lwChance);
        total += printScoreRow("YAHTZEE BONUS", lowBonus);
        
        return total;
    }
}
