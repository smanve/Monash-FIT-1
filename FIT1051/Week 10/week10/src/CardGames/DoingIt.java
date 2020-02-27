package CardGames;

/**
 * Created by shuxford
 */
public class DoingIt {
    Window myWindow;

    public void doIt(Window win){
        myWindow = win;

        //cardDriverTest();
        //deckDriverTest();
        //handDriverTest();
        gameDriverTest();
    }

    private void cardDriverTest(){
        Card c;

        myWindow.clearOut();

        for (int suit = 1; suit <= 4; suit++){
            for (int value = 1; value <= 13; value++){
                c = new Card(value, suit);
                myWindow.writeOutLine(c); //implied toString
            }
        }
    }

    private void deckDriverTest(){
        Deck d = new Deck();

        myWindow.clearOut();

        d.shuffle();

        for (int i = 1; i <= 52; i++)
            myWindow.writeOutLine(d.deal().toString());
    }

    private void handDriverTest(){
        Deck d = new Deck();
        Hand h = new Hand(5);

        myWindow.clearOut();

        d.fill(); d.shuffle();

        myWindow.writeOutLine("deal OK: " + h.acceptCard(d.deal()));
        myWindow.writeOutLine(h); //implicit toString

        myWindow.writeOutLine("deal OK: " + h.acceptCard(d.deal()));
        myWindow.writeOutLine(h);

        myWindow.writeOutLine("deal OK: " + h.acceptCard(d.deal()));
        myWindow.writeOutLine(h);

        myWindow.writeOutLine("deal OK: " + h.acceptCard(d.deal()));
        myWindow.writeOutLine(h);

        myWindow.writeOutLine("deal OK: " + h.acceptCard(d.deal()));
        myWindow.writeOutLine(h);

        myWindow.writeOutLine("deal OK: " + h.acceptCard(d.deal()));
        myWindow.writeOutLine(h);
    }

    private void gameDriverTest(){
        Game aGame = new Game(4, 5);

        myWindow.clearOut();

        aGame.play();
        myWindow.writeOutLine(aGame); //implicit toString
    }
}
