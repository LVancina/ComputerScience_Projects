public class Card
{
    private int rank;
    private String suit;

    //public interfaces for Card
    public Card()
    {
        rank = 0;
        suit = "na";
    }

    public Card(int r, String s)
    {
        rank = r;
        suit = s;
    }

    //represent a card in an easily comparable way
    public int getSuitRank()
    {
        int compare = 0;
        int suitVal;

        if(this.suit == "SPADES")
        {
            suitVal = 300;
            compare = suitVal + this.rank;
        }
        else if(this.suit == "HEARTS")
        {
            suitVal = 200;
            compare = suitVal + this.rank;
        }
        else if(this.suit == "DIAMONDS")
        {
            suitVal = 100;
            compare = suitVal + this.rank;
        }
        else if(this.suit == "CLUBS")
        {
            suitVal = 0;
            compare = suitVal + this.rank;
        }
        else
        {
            System.out.println("Invalid suit");
            System.exit(1);
        }
        return compare;
    }

    public int getRankSuit()
    {
        int compare = 0;
        int suitVal;

        if(this.suit == "SPADES")
        {
            suitVal = 3;
            compare = suitVal + this.rank * 10;
        }
        else if(this.suit == "HEARTS")
        {
            suitVal = 2;
            compare = suitVal + this.rank * 10;
        }
        else if(this.suit == "DIAMONDS")
        {
            suitVal = 1;
            compare = suitVal + this.rank * 10;
        }
        else if(this.suit == "CLUBS")
        {
            suitVal = 0;
            compare = suitVal + this.rank * 10;
        }
        else
        {
            System.out.println("Invalid suit");
            System.exit(1);
        }
        return compare;
    }
    
    //compare two cards based off first suit and then rank
    public static int compareSuitRank(Card a, Card b)
    {
        int compareA = a.getSuitRank();
        int compareB = b.getSuitRank();
        if(compareA > compareB)
            return 1;
        else if(compareA < compareB)
            return -1;
        else
            return 0;
    }

    //compare two cards based off first rank and then suit
    public static int compareRankSuit(Card a, Card b)
    {
        int compareA = a.getRankSuit();
        int compareB = b.getRankSuit();

        if(compareA > compareB)
            return 1;
        else if(compareA < compareB)
            return -1;
        else
            return 0;
    }

    //allows the particular card to be printed in a way that makes sense
    public String toString()
    {
        if(this.rank == 1)
            return "Ace of " + suit;
        if(this.rank == 11)
            return "Jack of " + suit;
        if(this.rank == 12)
            return "Queen of " + suit;
        if(this.rank == 13)
            return "King of " + suit;
        else
            return rank + " of " + suit;

    }
}
