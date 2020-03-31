package CardGames;

/**
 * Created by shuxford
 */
public class Hand {
    Card[] theHand;
    int cardsInHand;

    //CONSTRUCTORS
    public Hand(int capacity){
        theHand = new Card[capacity];
        cardsInHand = 0;
    }

    //ACCESSORS
    //the getCard method deals with all outbound functionality
    public int getCardsInHand(){
        return cardsInHand;
    }

    //quasi-accessor
    //theHand is an internal matter but game logic will need to examine the cards in a hand
    public Card getCard(int cardNumber){
        return theHand[cardNumber]; //PRIVACY LEAK
    }

    //MUTATORS
    //theHand is an internal matter
    //cardsInHand is an internal matter wrt to write access

    //OTHER METHODS
    public boolean acceptCard(Card aCard){
        boolean success = true;
        if (cardsInHand < theHand.length){
            theHand[cardsInHand] = aCard;
            cardsInHand++;
            success = true;
        }
        else
            success = false;

        return success;
    }

    public boolean acceptCardAt(Card aCard, int index){
        boolean success = true;
        if (index >= 0 && index < theHand.length){
            theHand[index] = aCard;
            success = true;
        }
        else
            success = false;

        return success;
    }

    public String toString(){
        String state = "";

        state += "This hand currently contains " + cardsInHand  + " out of " + theHand.length + " cards.\n";

        for (int i = 0; i < cardsInHand; i++)
            state += "\t" + theHand[i] + "\n";

        return state;
    }
}
