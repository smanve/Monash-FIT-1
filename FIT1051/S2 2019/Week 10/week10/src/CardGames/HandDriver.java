package CardGames;

/**
 * Created by shuxford
 */
public class HandDriver {
    public static void main(String[] args) {
        Deck d = new Deck();
        Hand h = new Hand(5);

        d.fill(); d.shuffle();

        System.out.println("deal OK: " + h.acceptCard(d.deal()));
        System.out.println(h); //implicit toString

        System.out.println("deal OK: " + h.acceptCard(d.deal()));
        System.out.println(h);

        System.out.println("deal OK: " + h.acceptCard(d.deal()));
        System.out.println(h);

        System.out.println("deal OK: " + h.acceptCard(d.deal()));
        System.out.println(h);

        System.out.println("deal OK: " + h.acceptCard(d.deal()));
        System.out.println(h);

        System.out.println("deal OK: " + h.acceptCard(d.deal()));
        System.out.println(h);
    }
}
