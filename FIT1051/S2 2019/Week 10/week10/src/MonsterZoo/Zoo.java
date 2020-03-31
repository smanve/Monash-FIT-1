package MonsterZoo;

public class Zoo {
	private Monster[] monsters;
	//following must be maintained correctly within this class only
	//several methods below depend on its correctness at any given time
	//current number of monsters in zoo NOT zoo capacity
	private int numberOfMonsters;

	//CONSTRUCTORS
	public Zoo(int capacity){
		monsters = new Monster[capacity];
		numberOfMonsters = 0;
	}

	//ACCESSORS
	public int getCapacity(){ //accessor??? there is no instance variable called capacity
		return monsters.length;
	}

	public int getNumberOfMonsters(){
		return numberOfMonsters;
	}

	//MUTATORS
	//capacity of zoo cannot be changed, Java arrays are of fixed size
	//numberOfMonsters MUST NOT be mutated by the outside world
	//if set incorrectly methods below will either malfunction or
	//cause a run-time crash, this is why we hide data

	//OTHER METHODS

	public boolean fight(Monster aggressor, int aggresorLimbsLost, int aggressorEyesLost, Monster victim, int victimLimbsLost, int victimEyesLost) {
		boolean retVal = false;

		if

		return retVal;
	}

	public int getIndexOfAMonster(String nameToGet){
		int retValue = -1; //default is not found

		for (int i = 0; i < numberOfMonsters; i++)
			if (monsters[i].getName().equals(nameToGet))
				retValue = i;

		return retValue;
	}

	public Monster getAMonsterByIndex(int indexToGet){
		Monster retVal;
		if (indexToGet >= 0 && indexToGet < numberOfMonsters)
			retVal =  monsters[indexToGet]; //PRIVACY LEAK OUT
		else
			retVal = null;

		return retVal;
	}

	public Monster getAMonsterByName(String nameToGet){
		Monster retVal = null;
		for (int i = 0; i <= numberOfMonsters - 1; i++)
			if (monsters[i].getName().equals(nameToGet))
				retVal = monsters[i];

		return retVal; //PRIVACY LEAK OUT
	}

	//an append operation
	public boolean addAMonster(Monster monsterToAdd){
		boolean retValue = true;
		
		if (numberOfMonsters < monsters.length){ 
			monsters[numberOfMonsters] = monsterToAdd; //PRIVACY LEAK IN
			numberOfMonsters++;
		}
		else
			retValue = false;
		return retValue;
	}

	//an insert operation
	public boolean insertAMonster(Monster monsterToAdd, int indexToAddAt){
		boolean retValue = true;

		if (numberOfMonsters < monsters.length &&
				(indexToAddAt >= 0 && indexToAddAt <= numberOfMonsters - 1)){
			//create a gap
			//high -> high + 1, high -1 -> high, ... ,
			//indexToAddAt -> indexToAddAt + 1
			for (int i = numberOfMonsters - 1; i >= indexToAddAt; i--)
				monsters[i + 1] = monsters[i]; //shuffle right (up)


			monsters[indexToAddAt] = monsterToAdd; //PRIVACY LEAK IN
			numberOfMonsters++;
		}
		else
			retValue = false;
		return retValue;
	}
	
	public boolean removeAMonster(int indexToRemove){
		boolean retValue = true;
		
		if (indexToRemove >= 0 && indexToRemove <= numberOfMonsters - 1 ){
			//indexToRemove <- indexToRemove + 1,
			//indexToRemove + 1 <- indexToRemove + 2, ... , high - 1 <- high
			for (int i = indexToRemove; i <= numberOfMonsters - 2; i++)
				monsters[i] = monsters[i + 1]; //shuffle left (down)
			numberOfMonsters--;
		}
		else
			retValue = false;
		return retValue;
	}

	
	public String toString(){
		String outString;
		
		outString = numberOfMonsters + " monsters in the zoo";
		
		for (int i = 0; i <= numberOfMonsters -1; i++)
			outString += "\n\t" + monsters[i].toString() + "\n";

		return outString;
	}

	public String toStringShort(){
		String outString;

		outString = numberOfMonsters + " monsters in the zoo\n";

		for (int i = 0; i <= numberOfMonsters -1; i++)
			outString += monsters[i].toStringShort() + "\n";

		return outString;
	}
}
