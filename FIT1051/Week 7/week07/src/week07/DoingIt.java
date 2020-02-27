package week07;

/**
 * Created by shuxford on 25/12/2015.
 */
public class DoingIt {
    Window myWindow;

    //class level variables here

    public void doIt(Window win) {
        myWindow = win;

        //whileForPaste01();
        //whileForPaste02();
        //whileForPaste03();
        //whileForPaste04();

//        forForPaste01();
        //enhancedForForPaste01();
        //videoWhileLoopInfiniteLoop01();

        //I'm leaving you to code and organise your Lab Exercise methods from now on
//        lab1();
//        lab2();
//        lab3();
        lab4();
//        lab5();
//        lab6();
    }

    //LAB EXERCISES for you to code ===========================================

    private void lab1() {
        boolean dicesAreSame = false;
        int counter = 1;

        myWindow.clearOut();

        while (dicesAreSame != true) {
            int dice1Roll = getRandom(1,6);
            int dice2Roll = getRandom(1,6);

            myWindow.writeOutLine(counter + ") Dice 1: " + dice1Roll + ", Dice 2: " + dice2Roll);

            if (dice1Roll == dice2Roll) {
                dicesAreSame = true;
                myWindow.writeOutLine("The dices are same after " + counter + " tries.");
            }
            counter++;
        }
    }

    private void lab2() {
        myWindow.clearOut();
        int counter = 0;
        int sum = 0;
        int[] array = {1, 2, 3, 4, 5, 6};

        int arrayLength = array.length;

        while (counter < arrayLength) {
            sum += array[counter];
            counter++;
        }

        myWindow.writeOutLine("Total sum: " + sum);
    }

    private void lab3() {
        myWindow.clearOut();
        int counter = 0;
        int average = 0;
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        int arrayLength = array.length;

        while (counter < arrayLength) {
            average += array[counter];
            counter++;
        }

        average = average / arrayLength;

        myWindow.writeOutLine("Average of array: " + average);
    }

    private void lab4() {
        int counter = 0;
        int totalCount = 0;

        while (counter < 1000) {
            boolean dicesAreSame = false;
            int individualCounter = 1;

            myWindow.clearOut();

            while (dicesAreSame != true) {
                int dice1Roll = getRandom(1,6);
                int dice2Roll = getRandom(1,6);

                if (dice1Roll == dice2Roll) {
                    dicesAreSame = true;
                    totalCount += individualCounter;
                }
                individualCounter++;
            }
            counter++;
        }
        double average = totalCount/counter;

        myWindow.writeOutLine("The long term average is: " + average);
    }

    private void lab5() {
        myWindow.clearOut();
        String userInput = myWindow.readIn();
//        String array[] = {"hello", "this", "is", "a", "test", ""};
        String array[] = {};

        int arrayLength = array.length;

        int counter = 0;
        if (arrayLength == 0) {
            myWindow.writeOutLine("The array is empty.");
        } else {
            while (counter < arrayLength) {
                if (userInput.equalsIgnoreCase(array[counter])) {
                    myWindow.writeOutLine("The string " + userInput + " is at index " + counter);
                    break;r
                }
                counter++;
            }
        }
    }

    private void lab6() {
        myWindow.clearOut();
        for (int year = 1752; year <= 3000; year++) {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                myWindow.writeOutLine(year);
            }
        }
    }

    //I'm leaving you to code and organise your Lab Exercise methods from now on


    //WORKSHOP CODE for you to play with ======================================
    private void whileForPaste01() {
        int count = 0, total = 0;

        while (total < 1000) {
            total += getRandom(1, 6); //see utility methods below
            count++;
        }

        myWindow.clearOut();
        myWindow.writeOutLine("Count: " + count);
    }

    private void whileForPaste02() {
        int counter;
        int limit = 100;
        final int SENTINEL = -1 + (int) (Math.random() * 12); //[-1 .. 10]
        int value = 0;
        boolean condition = false;

        //use a for loop for best style
        counter = 0; // or 1 depending on statements in loop block
        while (counter <= limit) { //or < or >= or > (== and != are risky, they could be skipped over)

            //process

            counter++; //or some other incrementing/decrementing
        }

        //get initial value from source
        while (value != SENTINEL) { //!value.equals(SENTINEL) for Strings

            //process input

            //get next value from source
        }

        //perform potential condition changing calculations with initial values
        while (condition) {

            //process

            //perform potential condition changing calculations with updated values
        }
    }

    private void whileForPaste03() {
        final int SENTINEL = -1;
        int input = -1 + (int) (Math.random() * 12);
        myWindow.clearOut();

        while (input != SENTINEL)
            myWindow.writeOutLine(input);
        input = -1 + (int) (Math.random() * 12);

        while (input != SENTINEL)
            myWindow.writeOutLine(input);
        input = -1 + (int) (Math.random() * 12);

        while (input != SENTINEL) {
            myWindow.writeOutLine(input);
            input = -1 + (int) (Math.random() * 12);
        }
        ;

        while (input != SENTINEL) ;
        {
            myWindow.writeOutLine(input);
            input = -1 + (int) (Math.random() * 12);
        }
    }

    private void whileForPaste04() {
        int[] someArray = {1, 2, 3, 4, 5};
        int i;

        i = 0;
        while (i < someArray.length) {   // takes care of an empty array
            //but not a null array
            // process the ith element using someArray[i] to access its value

            i++;
        }
    }


    private void forForPaste01() {
        final int MULTIPLIER = 7;
        int result;

        myWindow.clearOut();
        for (int i = 10; i >= 1; i--) {
            result = i * MULTIPLIER;
            myWindow.writeOutLine("7 X " + i + " = " + result);
        }
    }

    private void enhancedForForPaste01() {
        int[] bigScreenTVMonthlyUnitsSold = {435, 151, 120, 134, 199, 201, 312, 147, 107, 127, 115, 258};
        int monthCount = 0;

        for (int elem : bigScreenTVMonthlyUnitsSold) {
            if (elem >= 200)
                monthCount++;

        }

        myWindow.clearOut();
        myWindow.writeOutLine("Number of months: " + monthCount);
    }

    private void videoWhileLoopInfiniteLoop01() {

        int i = 1;

        while (i != 10) {
            //process

            i = i + 2;
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
