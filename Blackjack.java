import java.util.Random;                                                       // Imported for specific numbers. The numbers are not truly random.

import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        P1Random randomNumber = new P1Random();

       int gameCount = 0;
       int dealerWins = 0;
       int playerWins = 0;
       int tieGames = 0;

                                                                                  // Scanner and random are declared once;
        boolean continueGame = true;

        while (continueGame)                                                      // continueGame will always be true because it is assigned as true.
        {
            int playerHand = 0;

            gameCount++;

            System.out.println("START GAME #" + gameCount + "\n");

            int dealtCard = randomNumber.nextInt(13) + 1;

            if (dealtCard == 11)
            {
                System.out.println("Your card is a JACK!");
                playerHand = playerHand + 10;
                System.out.println("Your hand is: " + playerHand + "\n");           // Jack, kings, queens and kings are all assigned values to distinguish them but all add 10 to the player hand.
            }
            else if (dealtCard == 12) {
                System.out.println("Your card is a QUEEN!");
                playerHand = playerHand + 10;
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else if (dealtCard == 13) {
                System.out.println("Your card is a KING!");
                playerHand = playerHand + 10;
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else if (dealtCard == 1) {
                System.out.println("Your card is a ACE!");
                playerHand = playerHand + 1;
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else {
                System.out.println("Your card is a " + dealtCard + "!");
                playerHand = playerHand + dealtCard;
                System.out.println("Your hand is: " + playerHand + "\n");          // If the card value is != a jack, king, queen, or ace, let the randomized card be added to the player hand is just dealtCard.
            }

            System.out.println("1.Get another card" +
                               "\n2.Hold hand" +
                               "\n3.Print statistics" +
                               "\n4.Exit" +
                               "\n");

            System.out.println("Choose an option: ");

            int userMenu = input.nextInt();

            while (true)
            {
                
            if (userMenu == 1)
            {
                dealtCard = randomNumber.nextInt(13) + 1;

                if (dealtCard == 11)
                {                                                                // If player chooses option 1 run the same action as outer loop.
                    System.out.println("Your card is a JACK!");
                    playerHand = playerHand + 10;
                    System.out.println("Your hand is: " + playerHand + "\n");
                }
                else if (dealtCard == 12) {
                    System.out.println("Your card is a QUEEN!");
                    playerHand = playerHand + 10;
                    System.out.println("Your hand is: " + playerHand + "\n");
                }
                else if (dealtCard == 13) {
                    System.out.println("Your card is a KING!");
                    playerHand = playerHand + 10;
                    System.out.println("Your hand is: " + playerHand + "\n");
                }
                else if (dealtCard == 1) {
                    System.out.println("Your card is a ACE!");
                    playerHand = playerHand + 1;
                    System.out.println("Your hand is: " + playerHand + "\n");

                }                                                               // No break statements are needed each of these statements can only be true once.
                else {
                    System.out.println("Your card is a " + dealtCard + "!");
                    playerHand = playerHand + dealtCard;
                    System.out.println("Your hand is: " + playerHand + "\n");
                }
                if (playerHand > 21)
                {
                    System.out.println("You exceeded 21! You lose." + "\n");
                    dealerWins++;
                    break;
                }
                else if (playerHand == 21)
                {
                    System.out.println("BLACKJACK! You win!" + "\n");
                    playerWins++;
                    break;
                }
                System.out.println("1.Get another card" +
                        "\n2.Hold hand" +
                        "\n3.Print statistics" +                                // Break statements are needed to prevent text from being printed infinitely
                        "\n4.Exit" +
                        "\n");

                System.out.println("Choose an option: ");

                userMenu = input.nextInt();

            }
            else if (userMenu == 2)
            {
                int dealerCard = randomNumber.nextInt(11) + 16;
                if (dealerCard > 21)
                {
                    System.out.println("Dealer's hand: " + dealerCard);
                    System.out.println("Your hand is: " + playerHand + "\n");
                    System.out.println("You win!" + "\n");
                    playerWins++;                                              // Only the dealers hand will change. Dealer's hand will determine who wins or loses
                    break;
                }
                else if (playerHand > dealerCard)
                {
                    System.out.println("Dealer's hand: " + dealerCard);
                    System.out.println("Your hand is: " + playerHand + "\n");
                    System.out.println("You win!" + "\n");
                    playerWins++;
                    break;                                                     //if your hand is bigger than dealers, then you win
                }
                else if (dealerCard > playerHand)
                {
                    System.out.println("Dealer's hand: " + dealerCard);
                    System.out.println("Your hand is: " + playerHand + "\n");
                    System.out.println("Dealer wins!" + "\n");
                    dealerWins++;
                    break;
                }
                else
                {                                                               // player wins and dealer wins are incremented after every win. And there are break statements make to prevent repeated text.
                    System.out.println("Dealer's hand: " + dealerCard);
                    System.out.println("Your hand is: " + playerHand + "\n");
                    System.out.println("It's a tie! No one wins!" + "\n");
                    tieGames++;
                    break;
                }

            }
            else if (userMenu == 3)
            {
                System.out.println("Number of Player wins: " + playerWins);     // when 3 is chosen, display statistics without making a new game but while displaying options again
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + tieGames);
                double decimal = 0.0;
                System.out.println("Total # of games played is: " + (gameCount - 1));           // because a new game is not make, gameCount should not change. -1 cancels out the increment in this case.
                System.out.println("Percentage of Player wins: " + (((playerWins + decimal) / (gameCount-1) * 100) + "%" + "\n"));
                System.out.println("1.Get another card" +
                        "\n2.Hold hand" +
                        "\n3.Print statistics" +
                        "\n4.Exit" +
                        "\n");

                System.out.println("Choose an option: ");

                userMenu = input.nextInt();

            }
            else if (userMenu == 4)
            {                                                                         // Because continueGame being true is the condition for the outer loop, when it is false the game is terminated.
                continueGame = false;
                break;
            }
            else
            {
                System.out.println("Invalid input!" +
                        "\nPlease enter an integer value between 1 and 4." + "\n");
                System.out.println("1.Get another card" +
                        "\n2.Hold hand" +
                        "\n3.Print statistics" +
                        "\n4.Exit" +
                        "\n");

                System.out.println("Choose an option: ");

                userMenu = input.nextInt();
            }
            }                                                                         // Any number below one, above 4, or is a decimal is an invalid input. A break statement prevents repeated text.

        }

    }
}



