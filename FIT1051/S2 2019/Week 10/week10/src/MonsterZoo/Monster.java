package MonsterZoo;

public class Monster {
	//static for demo, auto-initialised to 0 as a class level variable
    private static int numMonstersInstantiated;

	//in its simplest form an enum is like a very simple class type
	//that just has named public constants which have values of 0, 1, 2, ...
	//which are associated with specified names EnumTypeName.FIRST_CONSTANT
	//EnumTypeName.SECOND_CONSTANT, EnumTypeName.THIRD_CONSTANT, ...
	public static enum TemperamentEnum {AGGRESSIVE, PASSIVE, UNDETERMINED};

	private String name;
	private Date dob;
	private int numberOfLimbs;
	private int numberOfEyes; 
	private boolean canFly; 
	private Food favouriteFood; 
	private TemperamentEnum temperament;
	private double lifetimeFeed; 

    //CONSTRUCTORS
	//constructor for setting instance variables during instantiation
	public Monster(String initName, Date initDob,
				   int initNumberOfLimbs, int initNumberOfEyes,
				   boolean initCanFly, Food initFavoutiteFood, TemperamentEnum initTemperament){
		
		name = initName;
		dob = initDob; //privacy leak
		setNumberofLimbs(initNumberOfLimbs);
		setNumberofEyes(initNumberOfEyes);
		canFly = initCanFly;
		favouriteFood = initFavoutiteFood; //privacy leak
		temperament = TemperamentEnum.UNDETERMINED;
		
		lifetimeFeed = 0.0; //cannot be set via constructor intentionally

		//static demo (this increment must appear in all monster constructors)
        numMonstersInstantiated++;
	}

	//constructor for setting instance variables as required
	//after instantiation via mutators
	public Monster(String initName){
		name = initName;

        //settling for the auto-initialised default values
		//for all other (class level)instance variables

		//static demo (this increment must appear in all monster constructors)
        numMonstersInstantiated++;
	}
	
	//ACCESSORS
    public String getName(){
		return name;
	}
	
	public int getNumberOfLimbs(){
		return numberOfLimbs;
	}

	public int getNumberOfEyes(){
		return numberOfEyes;
	}

	public TemperamentEnum getTemperament(){
		return temperament;
	}

	//more accessors ...
	
	//MUTATORS
	//name, dob, canFly, favouriteFood are immutable after instantiation

	public void setNumberofLimbs(int newNumberOfLimbs){
		if (newNumberOfLimbs >= 0)
			numberOfLimbs = newNumberOfLimbs;
	}

	public void setNumberofEyes(int newNumberOfEyes){
		if (newNumberOfEyes >= 0)
			numberOfEyes = newNumberOfEyes;
	}

	//quasi-mutators
	//single serve eat
	public boolean eat(Food someFood){
		boolean retValue = false;

        //monsters will only eat their favourite food
		if (someFood.getName().equals(favouriteFood.getName())){
			lifetimeFeed += someFood.getServingSize();
			retValue = true;
		}
		
		return retValue;
	}

	//multiple serves of favourite food
	public void eat(int numServes){

		lifetimeFeed += numServes * favouriteFood.getServingSize();

	}

	public void setTemperament(TemperamentEnum newTemparement){
		//Java will reject everything but the 3 valid values of enum Temperament
		temperament = newTemparement;
	}

	public void loseALimb(){
		if (numberOfLimbs - 1 >= 0) //if there are limbs to lose
			numberOfLimbs--;
	}

	public void loseAnEye(){
		if (numberOfEyes - 1 >= 0) //if there are eyes to lose
			numberOfEyes--;
	}


    //OTHER METHODS
	public String toString(){
		String outString = "";
		
		outString += name;
		outString += ", DOB: " + ((dob == null) ? "null dob" : dob.toString());
		outString += "\n\tlimbs: " + numberOfLimbs;
		outString += ", eyes: " + numberOfEyes;
		outString += ", lifetime feed: " + lifetimeFeed;
		outString += ", temperament: " + temperament;
		outString += "\n\tmore attributes, ...";
		
		return outString;
	}

	public String toStringShort(){
		String outString = "";

		outString += name;
		outString += ", DOB: " + ((dob == null) ? "null dob" : dob.toString());

		return outString;
	}

	//STATIC METHODS

    //following method does not need to be static (bad java!) but stylistically
	//it sends the right message
    //if it was non-static it would have to be invoked on a Monster object but
    //would not select that object which also sends the wrong message
    //btw try referring to an instance variable or non-static method
	//in this method!!!

    public static int getNumMonstersInstantiated(){ //static demo
		//following will not compile - static methods cannot distinguish instances
        //System.out.println(name);
        //System.out.println(getNumberOfLimbs());

        return numMonstersInstantiated;
    }
}






