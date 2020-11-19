// YAHTZEE programmed by Brian Rogers.
// For rules, see `printHelp`.
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
        printHelp();
    }
}
