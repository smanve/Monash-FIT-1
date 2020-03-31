package MonsterZoo;

public class Food {
	
	private String name;
	private double servingSize; //kilograms
	
	//CONSTRUCTORS
    public Food(String initName, double initServingSize){
		name = initName;
		
		if (initServingSize > 0)
			servingSize = initServingSize; 
	}
	
	//ACCESSORS
    public String getName(){
		return name;
	}

	public double getServingSize(){
		return servingSize;
	}

	//MUTATORS
    //no mutators, once a food is created it's intentionally immutable

    //OTHER METHODS
	public String toString(){
		String outString;
		
		outString = name + " (" + servingSize + ")";
		
		return outString;
	}
}

