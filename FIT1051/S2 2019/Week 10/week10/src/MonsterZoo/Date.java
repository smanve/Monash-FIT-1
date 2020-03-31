package MonsterZoo;

public class Date {

	private int day;
	private int month;
	private int year;

    //CONSTRUCTORS
	public Date(int initDay, int initMonth, int initYear){
		if (validateDate(initDay, initMonth, initYear)){
			day = initDay;
			month = initMonth;
			year = initYear;
		}		
	}

	//ACCESSORS
	//no accessors, date can only be accessed as a whole via toString()

	//MUTATORS
	//no mutators, date can only be set as a whole via constructor

	//OTHER METHODS
	public String toString(){
		String outString;
		
		outString = day + "/" + month + "/" + year;
		
		return outString;
	}

	private boolean validateDate(int rawDay, int rawMonth, int rawYear){
        boolean valid = true;

        // validation code - set valid false if any invalidity is found
        if (rawDay < 1 || rawDay > 31)
            valid = false;

        //etc

        return valid;
    }

}

