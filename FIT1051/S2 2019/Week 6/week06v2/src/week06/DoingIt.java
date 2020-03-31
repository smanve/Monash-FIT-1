package week06;

/**
 * Created by shuxford on 25/12/2015.
 */
public class DoingIt {
    Window myWindow;

    //class level variables here

    public void doIt(Window win) {
        myWindow = win;

        //ifTrapForPaste1();
        //ifElseIfElseForPaste1();
        //ifElseIfElseForPaste2();
        //ternaryOperator();
        //codeForVideos1();
        //codeForVideos2();

        lab1();
        //I'm leaving you to code and organise your Lab Exercise methods from now on

//        testing();

    }

    //LAB EXERCISES for you to code ===========================================
    private void lab1(){
        String gender = myWindow.readIn();
        myWindow.clearOut();
        if (gender.equalsIgnoreCase("f")){
            myWindow.writeOutLine("female");
        } else if (gender.equalsIgnoreCase("m")) {
            myWindow.writeOutLine("male");
        } else if (gender.isEmpty()) {
            myWindow.writeOutLine("not available");
        } else {
            myWindow.writeOutLine("ERROR");
        }
    }

    //I'm leaving you to code and organise your Lab Exercise methods from now on


    //WORKSHOP CODE for you to play with ======================================
    private void ifTrapForPaste1() {
        int temperature = (int) Math.random() * 100;
        String clothesList = "";

        if (temperature < 18) {
            clothesList = clothesList + " " + "coat";
        }

        // or since the statement block contains one and only one statement
        // we may dispense with the braces.

        if (temperature < 18)
            clothesList = clothesList + " " + "coat";

        if (temperature < 18)
            myWindow.writeOut("one");
        myWindow.writeOutLine("two");
    }

    private void ifElseForPaste() {
        String coin = myWindow.readIn();
        boolean youWin;

        myWindow.clearOut();

        if (coin.equals("heads")) {
            youWin = true;
        } else {
            youWin = false;
        }

        //or
        if (coin.equals("heads"))
            youWin = true;
        else
            youWin = false;


        myWindow.writeOutLine(youWin + ""); //quick and dirty cast

        youWin = coin.equals("heads"); //equivalent?
        myWindow.writeOutLine(youWin + ""); //quick and dirty cast

    }

    private void ifElseIfElseForPaste1() {
        String openHours, closeHours;
        String day = "Saturday";

        myWindow.clearOut();

        if (day.equals("Monday") || day.equals("Tuesday") ||
                day.equals("Wednesday") || day.equals("Thursday") ||
                day.equals("Friday")) {
            openHours = "9:00am";
            closeHours = "5:00pm";
        } else if (day.equals("Saturday")) {
            openHours = "9:00am";
            closeHours = "6:00pm";
        } else if (day.equals("Sunday")) {
            openHours = "10:00am";
            closeHours = "3:00pm";
        } else {
            openHours = "E R R O R";
            closeHours = "E R R O R";
        }

        myWindow.writeOutLine(openHours + " " + closeHours);
    }

    private void ifElseIfElseForPaste2() {
        String openHours, closeHours;
        String day = "Saturday";

        myWindow.clearOut();

        if (day.equals("Monday") || day.equals("Tuesday") ||
                day.equals("Wednesday") || day.equals("Thursday") ||
                day.equals("Friday")) {
            openHours = "9:00am";
            closeHours = "5:00pm";
        } else if (day.equals("Saturday")) {
            openHours = "9:00am";
            closeHours = "6:00pm";
        } else if (day.equals("Sunday")) {
            openHours = "10:00am";
            closeHours = "3:00pm";
        } else {
            openHours = "E R R O R";
            closeHours = "E R R O R";
        }

        myWindow.writeOutLine(openHours + " " + closeHours);
    }

    private void ternaryOperator() {
        String displayHours;

        myWindow.clearOut();

        int clockHours24 = 1 + (int) (Math.random() * 24);
        int clockHours12 = clockHours24 % 12;

        System.out.println(clockHours24);

        displayHours = clockHours12 + (clockHours24 < 12 ? " am" : " pm");

        myWindow.writeOutLine(displayHours);
    }

    private void codeForVideos1() {
        int i;
        String outString = "";

        myWindow.clearOut();

        i = 1 + (int) (Math.random() * 20);
        if (i < 10) {
            outString += "In the if statement block so ";
            outString += i + " is less than 10";
        } else {
            outString += "In the else statement block so ";
            outString += i + " is greater than or equal to 10";
        }

        myWindow.writeOutLine(outString);

        outString = "";
        i = 0;
        while (i < 10) {
            outString += i + " ";
            i++;
        }

        myWindow.writeOutLine(outString);
    }

    private void codeForVideos2() {
        int i, numInRow;
        String outString = "";

        myWindow.clearOut();

        i = 1;
        numInRow = 0;
        while (i <= 100) {
            outString += i + " ";

            numInRow++;
            if (numInRow == 10) {
                outString += "\n";
                numInRow = 0;
            }

            i++;
        }

        myWindow.writeOutLine(outString);
    }

    private void moreMessingAbout() {
        int age = 0;
        String gender = "female";
        int femaleCounter = 0, maleCounter = 0;
        int adultFemaleCounter = 0, adultMaleCounter = 0;
        int adultCounter = 0, nonAdultCounter = 0;
        int otherCounter = 0;
        int nonFemaleCounter = 0;

        age = Integer.parseInt(myWindow.readIn());

        if (gender.equals("female"))
            femaleCounter++;
        else
            maleCounter++;

        myWindow.writeOutLine(femaleCounter);
        myWindow.writeOutLine(maleCounter);

        if (age >= 18)
            if (gender.equals("female"))
                adultFemaleCounter++;

        if (age >= 18 && gender.equals("female"))
            adultFemaleCounter++;


        if (age >= 18)
            otherCounter++;
        if (gender.equals("female"))
            otherCounter++;

        if (gender.equals("female"))
            otherCounter++;
        if (age >= 18)
            otherCounter++;

        if (age >= 18 || gender.equals("female"))
            otherCounter++;


        if (age >= 18) {
            adultCounter++;

        } else {
            nonAdultCounter++;

        }

        if (age >= 18) {
            adultCounter++;

        }

        if (!(age >= 18)) {
            nonAdultCounter++;

        }

        if (gender.equals("female"))
            femaleCounter++;
        else if (age >= 18) {
            adultCounter++;
            nonFemaleCounter++;
        }

        if (gender.equals("female"))
            femaleCounter++;
        else if (age >= 18) {
            adultCounter++;
            nonFemaleCounter++;
        }


        if (gender.equals("female"))
            femaleCounter++;
        else if (age >= 18) {
            adultCounter++;
            nonFemaleCounter++;
        } else {
            //what counters should be incremented???
        }


        myWindow.writeOutLine(adultFemaleCounter);
        myWindow.writeOutLine(adultCounter);
        myWindow.writeOutLine(otherCounter);
        myWindow.writeOutLine(nonFemaleCounter);
        myWindow.writeOutLine(femaleCounter);
        myWindow.writeOutLine(nonAdultCounter);

    }

    private void testing() {

        int dayNumber;
        String suffix ="";

        myWindow.clearOut();

        //dayNumber = Integer.parseInt(myWindow.readIn());

        for (dayNumber = -5; dayNumber <=35; dayNumber++) {
            if (dayNumber == 1 || dayNumber == 21 || dayNumber == 31)
                suffix = "st";
            else if (dayNumber == 2 || dayNumber == 22)
                suffix = "nd";
            else if (dayNumber == 3 || dayNumber == 23)
                suffix = "rd";
            else if (dayNumber >= 4 && dayNumber <=20 || dayNumber >=24 && dayNumber <= 30)
                suffix = "th";
            else
                suffix = "ERROR";

            myWindow.writeOutLine(dayNumber + suffix);
        }
    }


    //==========================================================================
    // UTILITIES ===============================================================
    //==========================================================================
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private static int getRandom(int n1, int n2) {
        int retVal = 0;

        retVal = n1 + (int) Math.floor(Math.random() * (n2 - n1 + 1));

        return retVal;
    }

}
