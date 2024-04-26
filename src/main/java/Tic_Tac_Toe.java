import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tic_Tac_Toe {

    public static String[] winnerArray0 = {"0", "0", "0"};
    public static String winner0 = Arrays.toString(winnerArray0);
    public static String[] winnerArrayX = {"X", "X", "X"};
    public static String winnerX = Arrays.toString(winnerArrayX);
    public static String[][] arrays = new String[8][3];
    private static Boolean running = true;
    private static Boolean isBoardFull = false;
    public static ArrayList <String> stringArray = new ArrayList<>();


    public static void main(String[] args) {

        String[][] myArray = new String[3][3];

        runGame(myArray);

    }

    public static void runGame(String[][] myArray) {

        initializeGame(myArray);
        getUserInput(myArray);
    }


    public static void initializeGame(String[][] myArray) {

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = " ";
                stringArray.add(" ");
            }
        }
    }

    public static void printCurrentBoard(String[][] myArray) {

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " | ");

            }
            System.out.println();
        }
    }

    public static void getUserInput(String[][] myArray) {

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < myArray.length; i++) {

            if (!running) {
                printCurrentBoard(myArray);
                break;
            }
            for (int j = 0; j < myArray[i].length; j++) {
                {
                    if (running && !isBoardFull) {

                        printCurrentBoard(myArray);

                        System.out.println("Enter the row number: ");
                        int row = scan.nextInt();

                        System.out.println("Enter the column number: ");
                        int column = scan.nextInt();

                        System.out.println("Enter X or 0");
                        String element = scan.next();

                        //cell already occupied
                        if (myArray[row][column].equals(" ")) {
                            myArray[row][column] = element;
                        } else System.out.println("Enter another position, this one is not empty.");

                        createArrays(myArray);
//                        populateStringArray(myArray);
                        getWinner(arrays);
                        isBoardFull(myArray);
                    }
                }
            }
        }
    }

    public static void getWinner(String[][] arrays) {

        for (int i = 0; i < arrays.length; i++) {

            if (Arrays.toString(arrays[i]).equals(winner0)) {
                System.out.println("End of game! The winner is 0");
                running = false;
                break;

            } else if (Arrays.toString(arrays[i]).equals(winnerX)) {
                System.out.println("End of game! The winner is X");
                running = false;
                break;

            }
        }
    }

    public static void isBoardFull(String[][] myArray){

        for (int i = 0; i < stringArray.size(); i++) {
            if (stringArray.get(i).equals(" ")) {
                isBoardFull = false;
                break;

            } else if (i == stringArray.size()-1 && !stringArray.get(i).equals(" ")) {
                isBoardFull = true;
                System.out.println("Game over! No winners.");
                printCurrentBoard(myArray);
            }
        }
    }

    public static void printCreatedArrays(String[][] arrays) {

        for (int i = 0; i < arrays.length; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.println("This is the array" + i + " " + j + " " + arrays[i][j]);
            }
            System.out.println();
        }
    }

//    public static void populateStringArray (String myArraysCell){
//
//
////        for (int i = 0; i < myArray.length; i++){
////
////            for (int j = 0; j < myArray.length; j++){
//
//                stringArray.set(0, myArray[i][j]);
//            }
////        }
////    }

    public static void createArrays(String[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {

                String[] row0 = new String[3];
                String[] row1 = new String[3];
                String[] row2 = new String[3];
                String[] column0 = new String[3];
                String[] column1 = new String[3];
                String[] column2 = new String[3];
                String[] diag1 = new String[3];
                String[] diag2 = new String[3];

                row0[0] = myArray[0][0];
                row0[1] = myArray[0][1];
                row0[2] = myArray[0][2];

                row1[0] = myArray[1][0];
                row1[1] = myArray[1][1];
                row1[2] = myArray[1][2];

                row2[0] = myArray[2][0];
                row2[1] = myArray[2][1];
                row2[2] = myArray[2][2];

                column0[0] = myArray[0][0];
                column0[1] = myArray[1][0];
                column0[2] = myArray[2][0];

                column1[0] = myArray[0][1];
                column1[1] = myArray[1][1];
                column1[2] = myArray[2][1];

                column2[0] = myArray[0][2];
                column2[1] = myArray[1][2];
                column2[2] = myArray[2][2];

                diag1[0] = myArray[0][0];
                diag1[1] = myArray[1][1];
                diag1[2] = myArray[2][2];

                diag2[0] = myArray[0][2];
                diag2[1] = myArray[1][1];
                diag2[2] = myArray[2][0];

                arrays = new String[][]{row0, row1, row2, column0, column1, column2, diag1, diag2};

//                printCreatedArrays(arrays);
            }
        }
    }

}



/*

Add an array [3][3]

00  01  02

10  11  12

20  21  22


array [0][j]
array [1][j]
array [2][j]
array [i][0]
array [i][1]
array [i][2]

array [0][0], array[1][1], array[2][2]
array [0][2], array[1][1], array [2][0]




 */