package MonsterZoo;

/**
 * Created by shuxford
 */
public class ZooDriverFighting {
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

        m1.setTemperament(Monster.TemperamentEnum.PASSIVE);
        m3.setTemperament(Monster.TemperamentEnum.PASSIVE);

        m1.setNumberofLimbs(8); m1.setNumberofEyes(4);
        m3.setNumberofLimbs(4); m3.setNumberofEyes(1);


        System.out.println(theZoo.toString());
        //theZoo.fight(m3, 4, 0, m1, 3, 1);
        System.out.println(theZoo.toString());
    }


}
