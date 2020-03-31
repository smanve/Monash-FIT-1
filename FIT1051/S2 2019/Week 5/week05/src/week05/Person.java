package week05;

/**
 * Created by shuxford on 11/02/2016.
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName.length() > 0 && newName.length() <= 20)
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge >= 0 && newAge <=120)
            age = newAge;
    }
}
