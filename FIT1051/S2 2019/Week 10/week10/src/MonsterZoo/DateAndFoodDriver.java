package MonsterZoo;

public class DateAndFoodDriver {

	public static void main(String[] args) {

		Date goodDate = new Date(12, 11, 2016);
		System.out.println(goodDate); //implicit toString call
		
		Date badDate = new Date(32, 11, 2016);
		System.out.println(badDate);
		
		
		Food goodFood = new Food("good food", 1.2);
		System.out.println(goodFood);
		
		Food badFood = new Food("bad food", -3.4);
		System.out.println(badFood);
	}

}
