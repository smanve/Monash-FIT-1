package CardGames;

public class CardDriver {

    public static void main(String[] args) {
        Card c;

        for (int suit = 1; suit <= 4; suit++){
            for (int value = 1; value <= 13; value++){
                c = new Card(value, suit);
                System.out.println(c); //implied toString
            }
        }
    }


}
