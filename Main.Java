import java.util.Scanner;
import java.util.ArrayList; 



public class Main{
    public static void main(String[]args){
        

        ArrayList<String> fruits = new ArrayList<>(); //creates an array (easy way)
        // importing the scanner
       Scanner scanner = new Scanner(System.in);
    

        // tells the use what they need to input (obviously)
       System.out.println(" [1] Add Transactions [2] View accounts sheet [3] balance");
       int input = scanner.nextInt();
       scanner.nextLine();

       if (input == 1) {

        String[] data = new String[3];
        System.out.println("user -xxx for expenses and xxx for input (xxx represents numbers)");
        System.out.println("enter transcation # for the period");
        data[0] = scanner.nextLine();
        System.out.println("enter transcation Name");
        data[1] = scanner.nextLine();
        System.out.println("enter transcation ammount");
        data[2] = scanner.nextLine();
        
        dataManager.writeToCSV(data);

        


       }else if (input == 2) {
        dataManager.readCSV();
      
       }else if (input == 3){

        dataManager.seeBalance();
        
       }else {
         System.out.println("enter a valid command");
       }

       
    }
}