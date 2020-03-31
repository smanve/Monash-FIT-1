package MonsterZoo;

public class MonsterDriver {


	public static void main(String[] args) {
		Date aDate = new Date(1, 2, 2011);
		Food cookies = new Food("cookies", 3.0);
		
		Monster cookieMonster = new Monster("Cookie Monster", aDate, 4, 2, false, cookies, Monster.TemperamentEnum.PASSIVE);
		
		//lose legs and eyes
		System.out.println(cookieMonster); //implicit toString()
		System.out.println();
		cookieMonster.loseALimb();
		cookieMonster.loseALimb();
		cookieMonster.loseAnEye();
		System.out.println(cookieMonster);
		System.out.println();
		
		
		//eating
		Food notCookies = new Food("broccoli", 1.0);
		
		cookieMonster.eat(cookies);
		System.out.println(cookieMonster); //implicit toString()
		System.out.println();
		
		cookieMonster.eat(3);
		System.out.println(cookieMonster); //implicit toString()
		System.out.println();
		
		cookieMonster.eat(notCookies);
		System.out.println(cookieMonster); //implicit toString()
		System.out.println();

		//temperament
		cookieMonster.setTemperament(Monster.TemperamentEnum.PASSIVE);
		System.out.println(cookieMonster); //implicit toString()
		System.out.println();
	}

}
