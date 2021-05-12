/*
 * Date: May 8th, 2021
 * Name: Ryan M and Saad N
 * Teacher: Mr.Ho
 * Description: Benfords Law Sales Program
 * */

import java.util.Scanner;
import java.io.*;
import java.lang.Math;

// Packages used to generate graph (JFreeChart)
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

class BenfordsLawAssignment{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner reader = new Scanner(System.in);

        String userInput, loadSalesFile, generateBarGraph, generateCsvFile, exitCondition;
        loadSalesFile = "1";
        generateBarGraph = "2";
        generateCsvFile = "3";
        exitCondition = "9";
        int[] frequencyArray = new int[9];
        double[] finalValueArray = new double[9];

        do{
            printMenu();                                    
            userInput = reader.nextLine();                

            if (userInput.equals(loadSalesFile)){
                // Call loadSalesFile method
                loadSalesFile(frequencyArray, finalValueArray);
            }
            else if (userInput.equals(generateBarGraph)) {
                // Call generateBarGraph method
                generateBarGraph(finalValueArray);
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
    public static void printMenu(){
        System.out.println("Benfords Law\n"
        .concat("1. Load Sales File\n")
        .concat("2. Generate Bar Graph\n")
        .concat("3. Generate CSV File\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    public static void loadSalesFile(int[] valueArray, double[] percentArray) throws FileNotFoundException{
        // Reinitialized scanner (can't reach)
        Scanner reader = new Scanner(System.in);
        // Making sure the sales file is in same folder as the this program
        System.out.println("Make sure you have the sales file on your system and in same folder as this program in order to work");
        // Type in the file name and location (you can try only file name, but if not then just do the file name and location)
        System.out.println("Type your file name and location (e.g. C:\\Users\\Ryan Mah\\Desktop\\BLA\\sales)");
        
        // Input their file Name and Location
        String fileNameLocation = reader.nextLine(); 
        
        // Loops through each individual line
        Scanner file = new Scanner(new File(fileNameLocation + ".csv"));
        
        while (file.hasNextLine()){
            String s = file.nextLine().trim();
            valueArray = frequencyValues(s, valueArray);
        }
        
        percentValue(valueArray, percentArray);
    }
    public static int[] frequencyValues(String value, int[] firstDigitArray) {
        // Gets the fourth value of each line
        char firstValue = value.charAt(4);

        // If the value at the 4th character is 1, stores a counter into the array
        if (firstValue == '1') {
            firstDigitArray[0] += 1;
        }

        // If the value at the 4th character is 2, stores a counter into the array
        else if (firstValue == '2') {
            firstDigitArray[1] += 1;
        }

        // If the value at the 4th character is 3, stores a counter into the array
        else if (firstValue == '3') {
            firstDigitArray[2] += 1;
        }

        // If the value at the 4th character is 4, stores a counter into the array
        else if (firstValue == '4') {
            firstDigitArray[3] += 1;
        }

        // If the value at the 4th character is 5, stores a counter into the array
        else if (firstValue == '5') {
            firstDigitArray[4] += 1;
        }

        // If the value at the 4th character is 6, stores a counter into the array
        else if (firstValue == '6') {
            firstDigitArray[5] += 1;
        }

        // If the value at the 4th character is 7, stores a counter into the array
        else if (firstValue == '7') {
            firstDigitArray[6] += 1;
        }

        // If the value at the 4th character is 8, stores a counter into the array
        else if (firstValue == '8') {
            firstDigitArray[7] += 1;
        }

        // If the value at the 4th character is 9, stores a counter into the array
        else if (firstValue == '9') {
            firstDigitArray[8] += 1;
        }
          
        // Returns the array with counters stored for each frequency value
        return firstDigitArray;
    }
    public static int sumValue(int[] freqArray) {
        // Declare Variable
        int sum = 0;

        // Loops through the array and adds all the values up to 'sum' variable
        for (int i = 0; i < freqArray.length; i++) {
            sum += freqArray[i];
        }

        // Returns sum back to the percentValue method
        return sum;
    }
    public static void percentValue(int[] freqArray, double[] percentArray) {
        // Call sumValue method
        int total = sumValue(freqArray);

        // Places the percentage of each frequency value into a new double array
        // Rounded to one decimal place
        for (int i = 0; i < freqArray.length; i++) {
            percentArray[i] = Math.round((freqArray[i] * 1.0 / total) * 100 * 10.0) / 10.0;
        }

        // Call numericRepresentation method
        numericRepresentation(percentArray);

        // IF the first digit frequency is between the range 29<percentArray[0]<32, no fraud occurred
        // Otherwise, fraud was likely to have occurred
        if (percentArray[0] > 29 && percentArray[0] < 32) {
            System.out.println("Scanning the first digit frequency to see if it's within range");
            System.out.println("There is no fraud present");
        }
        else {
            System.out.println("Scanning the first digit frequency to see if it's within range");
            System.out.println("Fraud likely occurred");
        }
    }
    public static void numericRepresentation(double[] arr) {
        // Creates a numeric representation of the distribution of the first digits from 1 to 9
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Frequency Digit " + (i + 1) + " : " + arr[i] + " %");
        }
    }
    public static void generateBarGraph(double[] percentArray){
        // Declare variables that will be used in generating the graph
        String chartTitle = "Benford's Law Distribution Leading Digit";
        String xTitle = "First Digit Frequencies";
        String yTitle = "Percent (%)";

        // More variables that will be used within the x axis (first digit frequencies);
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";
        String five = "5";
        String six = "6";
        String seven = "7";
        String eight = "8";
        String nine = "9";
        String blank = "";

        // Adds dataset to input the values of the first digit frequencies
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Values of all the first digit frequencies inputted onto the chart
        dataset.addValue(percentArray[0], yTitle, one);
        dataset.addValue(percentArray[1], yTitle, two);
        dataset.addValue(percentArray[2], yTitle, three);
        dataset.addValue(percentArray[3], yTitle, four);
        dataset.addValue(percentArray[4], yTitle, five);
        dataset.addValue(percentArray[5], yTitle, six);
        dataset.addValue(percentArray[6], yTitle, seven);
        dataset.addValue(percentArray[7], yTitle, eight);
        dataset.addValue(percentArray[8], yTitle, nine);

        // Creates the bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
            chartTitle,
            xTitle, 
            yTitle,
            dataset, PlotOrientation.VERTICAL,
            true, true, false);

        // Size of the bar chart (width x height)
        int width = 640;
        int height = 480;

        // File name
        File BarChart = new File("BarChart.jpeg");
        
        // Saves the chart as a JPEG file into the folder used
        // If unable to, let's user know 'error' occurred
        try {
            ChartUtils.saveChartAsJPEG( BarChart, barChart, width, height);

        }
        catch (IOException e){ 
            System.out.println("Error");
        }
    }
    public static void generateCsvFile(){

    }
}
