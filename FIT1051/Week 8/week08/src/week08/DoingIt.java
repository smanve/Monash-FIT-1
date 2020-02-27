package week08;

/**
 * Created by shuxford on 25/12/2015.
 */
public class DoingIt {
    Window myWindow;

    //IMPORTANT - Window class refactored to instantiate 1 DoingIt object for all Do It button clicks
    //IMPORTANT - not instantiating 1 DoingIt object per Do It button click
    //IMPORTANT - This allows the class level variable "step" to persist between Do It button clicks

    int step = 1; //for method hierarchy example
    int goodCounter = 0; //for countExecutions example
    int counter = 0;


    public void doIt(Window win) {
        myWindow = win;

        //caller();
        //AnotherCaller();
        orchestratingMethod();

//        lab1();
//        lab2();
        lab3();
//        lab4();

        //I'm leaving you to code and organise your Lab Exercise methods from now on
    }

    //LAB EXERCISES for you to code ============================================

    //I'm leaving you to code and organise your Lab Exercise methods from now on

    private void lab1() {
        myWindow.clearOut();
        int[] intArray = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i < intArray.length; i++) {
            myWindow.writeOutLine(calledMethod1(intArray, i));
        }
    }

    private String calledMethod1(int[] intArray, int newInt) {
        String retVal;
        retVal = String.valueOf(intArray[newInt]);
        return retVal;
    }

    private void lab2() {
        int n1 = 5;
        int n2 = 6;
        myWindow.clearOut();

        myWindow.writeOutLine(calledMethod2(n1, n2));

        myWindow.writeOutLine(calledMethod2(n2, n1));
    }

    private int calledMethod2(int n2, int n1) {
        int retVal = n2 - n1;
        return retVal;
    }

    private void lab3(){
        myWindow.clearOut();
        for (int day = 1; day <= 31; day ++) {
            String newDay = String.valueOf(day);
            myWindow.writeOutLine(daySuffix(newDay));
        }
    }

    private String daySuffix(String aString) {
        String retVal = "";
        if (isNumeric(aString) == true) {
            double newDouble = Double.parseDouble(aString);
            newDouble = Math.round(newDouble);
            int newInt = (int) newDouble;
            if (newInt >= 1 && newInt <= 31) {
                if (newInt == 1 || newInt == 21 || newInt == 31) {
                    retVal = newInt + "st";
                } else if (newInt == 2 || newInt == 22) {
                    retVal = newInt + "nd";
                } else if (newInt == 3 || newInt == 23) {
                    retVal = newInt + "rd";
                } else {
                    retVal = newInt + "th";
                }
            }
        } else {
            retVal = null;
        }
        return retVal;
    }

    private void lab4(){
        myWindow.clearOut();
        int[] array1 = {2,3,4,5,6,7,8};
        for (int i = 0; i < array1.length; i++) {
            String result = calledMethod1(array1, i);
            if (result != null) {
                counter++;
            }
        }
        myWindow.writeOutLine(counter);
    }



    //WORKSHOP CODE for you to play with =======================================
    private void caller() {
        double number1 = 7.0;

        myWindow.clearOut();
        myWindow.writeOutLine("Before call to calledNoReturn()");
        calledNoReturn(number1 + 10.0, Math.pow(number1, 2));
        myWindow.writeOutLine("After call to calledNoReturn()");
    }

    private void calledNoReturn(double n1, double n2) {
        double sum = 0;
        sum = n1 + n2;
        myWindow.writeOutLine("calledNoReturn begins executing");
        myWindow.writeOutLine("sum of formal parameters is: " + sum);
        myWindow.writeOutLine("calledNoReturn finishes executing");
    }

    private void AnotherCaller() {
        double number1 = 7.0;

        myWindow.clearOut();
        myWindow.writeOutLine("Before call to calledReturn()");
        myWindow.writeOutLine(100.0 + calledReturn(number1 + 10.0, Math.pow(number1, 2)));
        myWindow.writeOutLine("After call to calledReturn()");
    }

    private double calledReturn(double n1, double n2) {
        double sum = 0;
        sum = n1 + n2;
        myWindow.writeOutLine("calledReturn begins executing");
        myWindow.writeOutLine("about to execute return statement");
        return sum;
        //myWindow.writeOutLine("calledReturn finishes executing"); unreachable statement
    }


    //==========================================================================
    //METHOD HIERARCHY - EXAMPLE
    private void orchestratingMethod() { //no display dependency
        String instructions = "";
        instructions += "Enter a comma separated list like: \n";
        instructions += "start table, end table, start range, end range, multiplication symbol.\n";
        instructions += "Then click the Do It! button again.";


        if (step == 1) { //step is class level
            prompt(instructions);
            step = 2;
        } else if (step == 2) {
            displayOutput(process(getInput())); //call sequence 1. getInput 2. process 3. displayOutput
            step = -1; //end step sequence
        } else {
            //do nothing, step sequence has finished
        }
    }

    private void prompt(String promptToDisplay) {
        myWindow.clearOut();
        myWindow.clearIn();

        myWindow.writeOutLine(promptToDisplay);
    }

    private String[] getInput() {
        return myWindow.readIn().split("\\s*,\\s*"); //splits into tokens
    }

    private String process(String[] splitInput) { //no display dependency
        int startTable, stopTable, from, to;
        String symbol;
        String result = "";

        //exception handling should start here
        startTable = Integer.parseInt(splitInput[0]);
        stopTable = Integer.parseInt(splitInput[1]);
        from = Integer.parseInt(splitInput[2]);
        to = Integer.parseInt(splitInput[3]);
        //exception handling should stop here

        symbol = splitInput[4];


        for (int i = startTable; i <= stopTable; i++) {
            result += ">>>" + i + " times table\n";
            result += timesTable(i, from, to, symbol) + "\n";
        }

        return result;
    }

    private void displayOutput(String toDisplay) {
        myWindow.clearOut();
        myWindow.writeOutLine(toDisplay);
    }

    private String timesTable(int tableNumber, int from, int to, String timesSymbol) {
        String table = "";

        for (int i = from; i <= to; i++) {
            table += String.format("%3d %s %3d = %3d\n", i, timesSymbol, tableNumber, i * tableNumber);
        }

        return table;
    }
    //==========================================================================


    // =========================================================================
    // UTILITIES ===============================================================
    // =========================================================================
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

}
