package CardGames;

public class DeckDriver {
    public static void main(String[] args) {
        Deck d = new Deck();

        d.shuffle();

        for (int i = 1; i <= 52; i++)
            System.out.println(d.deal().toString());
    }

}
