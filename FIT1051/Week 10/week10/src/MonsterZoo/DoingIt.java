package MonsterZoo;

/**
 * Created by shuxford
 */
public class DoingIt {
    Window myWindow;

    public void doIt(Window win){
        myWindow = win;

        dateAndFoodDriverTest();
        //monsterDriverTest();
        //zooDriverTest();
        //zooDriver2Test();
        //zooDriver3Test();
    }

    private void dateAndFoodDriverTest(){
        myWindow.clearOut();

        Date goodDate = new Date(12, 11, 2016);
        myWindow.writeOutLine(goodDate); //implicit toString call

        Date badDate = new Date(32, 11, 2016);
        myWindow.writeOutLine(badDate);


        Food goodFood = new Food("good food", 1.2);
        myWindow.writeOutLine(goodFood);

        Food badFood = new Food("bad food", -3.4);
        myWindow.writeOutLine(badFood);
    }

    private void monsterDriverTest(){
        myWindow.clearOut();

        Date aDate = new Date(1, 2, 2011);
        Food cookies = new Food("cookies", 3.0);

        Monster cookieMonster = new Monster("Cookie Monster", aDate, 4, 2, false, cookies, Monster.TemperamentEnum.PASSIVE);

        //lose legs and eyes
        myWindow.writeOutLine(cookieMonster); //implicit toString()
        myWindow.writeOutLine(""); //throe a line
        cookieMonster.loseALimb();
        cookieMonster.loseALimb();
        cookieMonster.loseAnEye();
        myWindow.writeOutLine(cookieMonster);
        myWindow.writeOutLine("");


        //eating
        Food notCookies = new Food("broccoli", 1.0);

        cookieMonster.eat(cookies);
        myWindow.writeOutLine(cookieMonster); //implicit toString()
        myWindow.writeOutLine("");

        cookieMonster.eat(3);
        myWindow.writeOutLine(cookieMonster); //implicit toString()
        myWindow.writeOutLine("");

        cookieMonster.eat(notCookies);
        myWindow.writeOutLine(cookieMonster); //implicit toString()
        myWindow.writeOutLine("");

        //temperament
        cookieMonster.setTemperament(Monster.TemperamentEnum.PASSIVE);
        myWindow.writeOutLine(cookieMonster); //implicit toString()
        myWindow.writeOutLine("");
    }

    private void zooDriverTest(){
        myWindow.clearOut();

        Zoo theZoo = new Zoo(5);
        //Zoo2 theZoo = new Zoo2(5);

        // add some monsters
        Monster m1 = new Monster("m1");
        Monster m2 = new Monster("m2");
        Monster m3 = new Monster("m3");

        //static class level test
        //note: number of monsters instantiated and number of monsters in the zoo are NOT the same thing
        myWindow.writeOutLine("\nMonster instantiated: " + Monster.getNumMonstersInstantiated() + "\n");

        theZoo.addAMonster(m1);
        theZoo.addAMonster(m2);
        theZoo.addAMonster(m3);

        //remove a monster
        myWindow.writeOutLine(theZoo.toString());
        theZoo.removeAMonster(theZoo.getIndexOfAMonster("m2"));
        myWindow.writeOutLine(theZoo.toString());

        //static class level test
        //note: number of monsters instantiated and number of monsters in the zoo are NOT the same thing
        myWindow.writeOutLine("\nMonster instantiated: " + Monster.getNumMonstersInstantiated() + "\n");

        //add (append) another monster
        Date aDate = new Date(1, 2, 2011);
        Food cookies = new Food("cookie", 3.0);
        Monster cookieMonster = new Monster("Cookie Monster", aDate, 4, 2, false, cookies, Monster.TemperamentEnum.PASSIVE);

        theZoo.addAMonster(cookieMonster); //PRIVACY LEAK
        myWindow.writeOutLine(theZoo.toString());

        //static class level test
        //note: number of monsters instantiated and number of monsters in the zoo are NOT the same thing
        myWindow.writeOutLine("\nMonster instantiated: " + Monster.getNumMonstersInstantiated() + "\n");

        //manipulate without removing from array - PRIVACY LEAK
        theZoo.getAMonsterByIndex(theZoo.getIndexOfAMonster("Cookie Monster")).eat(cookies);
        myWindow.writeOutLine(theZoo.toString());
    }

    private void zooDriver2Test(){
        myWindow.clearOut();

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

        myWindow.writeOutLine(theZoo.toStringShort());

        theZoo.removeAMonster(1);
        theZoo.removeAMonster(2);

        myWindow.writeOutLine(theZoo.toStringShort());

        Monster m6 = new Monster("m6");
        Monster m7 = new Monster("m7");


        theZoo.insertAMonster(m6, 1);
        theZoo.insertAMonster(m7, 3);

        myWindow.writeOutLine(theZoo.toStringShort());

        theZoo.insertAMonster(m2, 0);
        theZoo.insertAMonster(m2, 2);
        theZoo.insertAMonster(m2, 4);

        myWindow.writeOutLine(theZoo.toStringShort());
    }

    private void zooDriver3Test(){
        myWindow.clearOut();

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


        myWindow.writeOutLine(theZoo); //implicit toString()
        //theZoo.fight(m3, 4, 0, m1, 3, 1);
        myWindow.writeOutLine(theZoo);
    }
}
