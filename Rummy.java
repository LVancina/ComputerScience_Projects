public class Rummy
{
    public static void main(String[] args)
    {
        Deck myDeck = new Deck();
        Hand myHand = new Hand();

        myDeck.setDeck(); //create the deck of 52 cards
        for(int i = 0; i < 5; i++) //draw 5 cards into the hand from the deck
        {
            Card c = myDeck.deal();
            myHand.draw(c);
        }
        //print the cards in the hand
        System.out.println(myHand);

        //sort the hand by suit, then rank and print again
        myHand.head = Hand.sortSuitRank(myHand.head);
        System.out.println(myHand);

        //sort the hand by rank, then suit and print again
        myHand.head = Hand.sortRankSuit(myHand.head);
        System.out.println(myHand);

        //print any sets in the hand
        myHand.getSet(myHand.head);
    }
}