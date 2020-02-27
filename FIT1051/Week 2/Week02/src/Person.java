
public class Person {
    private int age;
    private String name;
    private String favouriteColour;

    public void setAge(int newAge){
        if (newAge > 0 && newAge <= 120)
            age = newAge;
    }

    public int getAge(){
        return age;
    }

    public void setName(String newName){


        if (newName.length() <= 20 && newName.length() >= 1)
            name = newName;
    }

    public String getName() {
        return name;
    }

    public void setFavouriteColour(String newColour) {
        if (newColour.length() >= 1 && newColour.length() <= 10)
            favouriteColour = newColour;
    }

    public String getFavouriteColour () {
        return favouriteColour;
    }

}


