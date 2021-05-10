/*
 * Date: May 8th, 2021
 * Name: Ryan M and Saad N
 * Teacher: Mr.Ho
 * Description: 
 * */

import java.util.Scanner;

class BenfordsLawAssignment{
    public static void main(String[] args) throws FileNotFoundException{
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
    public static void loadSalesFile() throws FileNotFoundException{
        // Reinitialized scanner (can't reach)
        Scanner reader = new Scanner(System.in);
        // Making sure the sales file is in same folder as the this program
        System.out.println("Make sure you have the sales file on your system and in same folder as this program in order to work");
        // Type in the file name and location (you can try only file name, but if not then just do the file name and location)
        System.out.println("Type your file name and location (e.g. C:\\Users\\Ryan Mah\\Desktop\\BLA\\sales)");
        
        // Input their file Name and Location
        String fileNameLocation = reader.nextLine(); 
        
        // Reading the file
        Scanner file = new Scanner(new File(fileNameLocation + ".csv"));
        
        // Here for now
        while (file.hasNextLine()){
            String s = file.nextLine().trim();
        }
    }
    public static void generateBarGraph(){

    }
    public static void generateCsvFile(){

    }
    /*
     *You can add more methods if needed
     */
}
