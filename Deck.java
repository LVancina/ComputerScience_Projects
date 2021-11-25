import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private ArrayList<Card> myDeck = new ArrayList<Card>();
    public static int[] cardRanks = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    public static String[] cardSuit = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};

    //create a deck with all 52 cards (no jokers)
    public void setDeck()
    {
        int i, j;
        for(i = 0; i < 4; i++)
        {
            for(j = 0; j < 13; j++)
            {
                myDeck.add(new Card(cardRanks[j], cardSuit[i]));
            }
        }
    }

    //deal a card randomly from the deck
    public Card deal()
    {
        Random rand = new Random();
        Card c = myDeck.get(rand.nextInt(myDeck.size()));
        myDeck.remove(c);
        return c;
    }
}