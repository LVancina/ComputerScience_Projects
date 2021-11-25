public class Hand
{
    public CardNode head;
    
    public Hand()
    {
        head = null;
    }

    public void draw(Card c)
    {
        CardNode node = new CardNode(c);
        CardNode current;

        if(head == null)
            head = node;
        else
        {
            current = head;
            while(current.next != null)
                current = current.next;
            current.next = node;
        }
    }

    public static CardNode sortSuitRank(CardNode hand)
    {
        CardNode current = hand; //point to first node in the list

        //while there's still nodes in the list
        while(current != null && current.next != null)
        {
            //iterate list until you find a node out of order
            if(Card.compareSuitRank(current.card, current.next.card) > 0)
                current = current.next;
            else
            {
                //make a pointer to the node you want to move
                CardNode move = current.next;
                //take the move node out of the list
                current.next = move.next;
                //find the node before the one you want to move in front of
                CardNode temp = hand;
                CardNode prev = null;
                while(Card.compareSuitRank(temp.card, move.card) > 0)
                {
                    prev = temp;
                    temp = temp.next;
                }
                if(prev == null)
                    hand = move; //adding move to the front of the list
                else //put move somewhere in the middle
                    prev.next = move;
                move.next = temp; //attach the rest of the list after move
                current = hand; //set pointer back to the beginning of the list
            }
        }
        return hand;
    }

    public static CardNode sortRankSuit(CardNode hand)
    {
        CardNode current = hand; //point to first node in the list

        //while there's still nodes in the list
        while(current != null && current.next != null)
        {
            //iterate list until you find a node out of order
            if(Card.compareRankSuit(current.card, current.next.card) > 0)
                current = current.next;
            else
            {
                //make a pointer to the node you want to move
                CardNode move = current.next;
                //take the move node out of the list
                current.next = move.next;
                //find the node before the one you want to move in front of
                CardNode temp = hand;
                CardNode prev = null;
                while(Card.compareRankSuit(temp.card, move.card) > 0)
                {
                    prev = temp;
                    temp = temp.next;
                }
                if(prev == null)
                    hand = move; //adding move to the front of the list
                else //put move somewhere in the middle
                    prev.next = move;
                move.next = temp; //attach the rest of the list after move
                current = hand; //set pointer back to the beginning of the list
            }
        }
        return hand;
    }

    public void getSet(CardNode head)
    {
        CardNode current = head; //point to the first node
        CardNode tempHead = null;
        CardNode set = null;

        //while there are nodes left
        while(current.next != null)
        {
            CardNode temp = null;
            int count = 0;
            //figure out if the cards are sequential rank in the same suit
            int comp = current.card.getSuitRank() - current.next.card.getSuitRank();
            if(comp == 1)
            {
                tempHead = current; //keep track of where the set starts
                while(comp == 1 && (current.next != null && current.next.next != null))
                {
                    temp = current;
                    temp.next = current.next;
                    current = current.next;
                    count++;
                    //check if the next card is also sequential
                    comp = current.card.getSuitRank() - current.next.card.getSuitRank();
                }
                if(count > 0)
                {
                    set = tempHead; //pass the list off to "set"
                    break;
                }
                else
                    current = tempHead; //go back to where we first started looking for a set
            }
            current = current.next; //increment the pointer
        }
        //start over, this time checking for sets of the same rank
        current = head;
        tempHead = null;

        while(current.next != null)
        {
            CardNode temp = null;
            int count = 0;
            //check if the items have the same rank
            int compCurr = current.card.getSuitRank() % 100;
            int compNext = current.next.card.getSuitRank() % 100;
            if(compCurr == compNext)
            {
                tempHead = current;
                while(compCurr == compNext && (current.next != null && current.next.next != null))
                {
                    temp = current;
                    temp.next = current.next;
                    current = current.next;
                    count++;
                    compCurr = current.card.getSuitRank() % 100;
                    compNext = current.next.card.getSuitRank() % 100;
                }
                if(count > 0)
                {
                    set = tempHead;
                    break;
                }
            }
            current = current.next;
        }
        //print out the set
        if(set != null)
        {
            CardNode temp = set;
            System.out.println("Set:");
            while(temp != null)
            {
                System.out.println(temp.card);
                temp = temp.next;
            }
        }
        else
        {
            System.out.println("No sets\n");
        }
        System.out.println("");
    }

    public String toString()
    {
        String result = "";
        CardNode current = head;
        while(current != null)
        {
            result += current.card + "\n";
            current = current.next;
        }
        return result;
    }
}