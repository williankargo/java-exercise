package onedimensionalarray;

public class PokerCard {

    public static void main(String[] args) {
        ///
        long start = System.currentTimeMillis();
        ///
        int[] deck = new int[52];
        String[] suits = {"Spade", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13"};

        //Initiate cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        //Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
            int j = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        //Display the first 5 cards
        for (int i = 0; i < 5; i++) {
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);

        }
        ///
        long end = System.currentTimeMillis();
        ///
        System.out.println("time:" + (end - start) / 1000);
    }
}
