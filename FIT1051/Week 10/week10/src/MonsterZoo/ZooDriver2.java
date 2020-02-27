package MonsterZoo;

/**
 * Created by shuxford
 */
public class ZooDriver2 {

    public static void main(String[] args) {
        Zoo theZoo = new Zoo(5);
        //Zoo2 theZoo = new Zoo2(5);

        // add some monsters
        Monster m1 = new Monster("m1");
        Monster m2 = new Monster("m2");
        Monster m3 = new Monster("m3");
        Monster m4 = new Monster("m4");
        Monster m5 = new Monster("m5");

        theZoo.addAMonster(m1);
        theZoo.addAMonster(m2);
        theZoo.addAMonster(m3);
        theZoo.addAMonster(m4);
        theZoo.addAMonster(m5);

        System.out.println(theZoo.toStringShort());

        theZoo.removeAMonster(1);
        theZoo.removeAMonster(2);

        //testing for godd and bad inserts
        if (theZoo.insertAMonster(m2, 2))
            System.out.println("Insert OK\n");
        else
            System.out.println("Insert Failed\n");

        System.out.println(theZoo.toStringShort());

        Monster m6 = new Monster("m6");
        Monster m7 = new Monster("m7");


        theZoo.insertAMonster(m6, 1);
        theZoo.insertAMonster(m7, 3);

        System.out.println(theZoo.toStringShort());

        theZoo.insertAMonster(m2, 0);
        theZoo.insertAMonster(m2, 2);
        theZoo.insertAMonster(m2, 4);

        System.out.println(theZoo.toStringShort());

    }
}
