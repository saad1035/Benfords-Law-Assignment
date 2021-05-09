/*
 * Date: May 8th, 2021
 * Name: Ryan M and Saad N
 * Teacher: Mr.Ho
 * Description: 
 * */

import java.util.Scanner;

class BenfordsLawAssignment{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        // Change these if you would like
        String userInput, loadSalesFile, generateBarGraph, generateCsvFile, exitCondition;
        loadSalesFile = "1";
        generateBarGraph = "2";
        generateCsvFile = "3";
        exitCondition = "9";

        do{
            printMenu();                                    
            userInput = reader.nextLine();                

            if (userInput.equals(loadSalesFile)){
                loadSalesFile();
            }
            else if (userInput.equals(generateBarGraph)) {
                generateBarGraph();
            }
            else if (userInput.equals(generateCsvFile)){
                generateCsvFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));
        
        reader.close();
        System.out.println("You have exited");
    }
    // Change these if you would like
    public static void printMenu(){
        System.out.println("Benfords Law\n"
        .concat("1. Load Sales File\n")
        .concat("2. Generate Bar Graph\n")
        .concat("3. Generate CSV File\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
     * Change these later below if you would like
     */
    public static void loadSalesFile() {

    }
    public static void generateBarGraph(){

    }
    public static void generateCsvFile(){

    }
    /*
     *You can add more methods if needed
     */
}
