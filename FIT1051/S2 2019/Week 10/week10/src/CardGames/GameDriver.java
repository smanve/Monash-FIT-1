package CardGames;

/**
 * Created by shuxford
 */
public class GameDriver {

    public static void main(String[] args) {
        Game aGame = new Game(4, 5);
        //GameLabEx aGame = new GameLabEx(4, 5);

        aGame.play();
        System.out.println(aGame); //implicit toString
    }

}
