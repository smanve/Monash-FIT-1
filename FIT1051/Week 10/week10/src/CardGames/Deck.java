package CardGames;

public class Deck {
    private Card[] theDeck;
    private int cardsLeft;

    //CONSTRUCTORS
    public Deck(){
        theDeck = new Card[53]; //not using theDeck[0]

        fill();
    }

    //ACCESSORS
    //the deal method takes care of all required outbound functionality
    public int getCardsLeft(){
        return cardsLeft;
    }

    //MUTATORS
    //theDeck is an internal matter so no mutator
    //cardsLeft is an internal matter wrt to writing, so no mutator

    //OTHER METHODS
    public String toString(){
        String state = "";

        for (int i = 1; i <= cardsLeft; i++)
            state += theDeck[i].toString();

        return state;
    }

    public void fill(){ //will fail if no deck constructed
        Card c;

        for (int suit = 1; suit <= 4; suit++)
            for (int value = 1; value <= 13; value++){
                c = new Card(value, suit);
                theDeck[(suit - 1) * 13 + value] = c;
            }

        cardsLeft = 52;
    }

    public void shuffle(){
        int r1, r2;
        Card temp;

        for (int i = 1; i <= 5200; i++){
            r1 = 1 + (int) (Math.random() * 52);
            r2 = 1 + (int) (Math.random() * 52);

            temp = theDeck[r1];
            theDeck[r1] = theDeck[r2];
            theDeck[r2] = temp;
        }
    }

    public Card deal(){
        Card dealtCard;

        if (cardsLeft >= 1){
            dealtCard = theDeck[cardsLeft];
            cardsLeft--;
        }
        else
            dealtCard = null;

        return dealtCard;
    }

}
