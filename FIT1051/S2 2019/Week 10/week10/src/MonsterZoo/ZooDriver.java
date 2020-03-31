package MonsterZoo;

public class ZooDriver {

	public static void main(String[] args) {
		Zoo theZoo = new Zoo(5);
		//Zoo2 theZoo = new Zoo2(5);
		
		// add some monsters
		Monster m1 = new Monster("m1");
		Monster m2 = new Monster("m2");
		Monster m3 = new Monster("m3");

        //static class level test
        //note: number of monsters instantiated and number of monsters in the zoo are NOT the same thing
        System.out.println("\nMonster instantiated: " + Monster.getNumMonstersInstantiated() + "\n");
		
		theZoo.addAMonster(m1);
		theZoo.addAMonster(m2);
		theZoo.addAMonster(m3);
		
		//remove a monster
		System.out.println(theZoo.toString());
		theZoo.removeAMonster(theZoo.getIndexOfAMonster("m2"));
		System.out.println(theZoo.toString());

        //static class level test
        //note: number of monsters instantiated and number of monsters in the zoo are NOT the same thing
        System.out.println("\nMonster instantiated: " + Monster.getNumMonstersInstantiated() + "\n");
		
		//add (append) another monster
		Date aDate = new Date(1, 2, 2011);
		Food cookies = new Food("cookie", 3.0);
		Monster cookieMonster = new Monster("Cookie Monster", aDate, 4, 2, false, cookies, Monster.TemperamentEnum.PASSIVE);
		
		theZoo.addAMonster(cookieMonster); //PRIVACY LEAK
		System.out.println(theZoo.toString());

        //static class level test
        //note: number of monsters instantiated and number of monsters in the zoo are NOT the same thing
        System.out.println("\nMonster instantiated: " + Monster.getNumMonstersInstantiated() + "\n");
		
		//manipulate without removing from array - PRIVACY LEAK
		theZoo.getAMonsterByIndex(theZoo.getIndexOfAMonster("Cookie Monster")).eat(cookies);
		System.out.println(theZoo.toString());
		
	}

}
