import java.util.Scanner;


/**
 * Simple program to manipulate strings
 * 
 * @author Collin Crowthers
 */
public class StringManipulation{

    public static void main(String[] args) {
        
        int input;
        String stIn;
        String stIn2;
        char cIn;
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        //main menu
        do{
            System.out.println("\n1. Check if string is a palindrome.");
            System.out.println("2. Count all occurences of a character.");
            System.out.println("3. Remove all occurences of a character.");
            System.out.println("4. Find all occurences of a substring.");
            System.out.println("5. Exit.");
            
            input = in.nextInt();
            System.out.println("");
            
            
            switch(input){
                
                case 1:
                    //Check if string is a palindrome
                    System.out.println("Enter string:");
                    stIn = in.next();
                    stIn = stIn.replace(" ","");
                    System.out.println(palindrome(stIn));
                    break;
                    
                case 2:
                    //Count all occurences of a character
                    System.out.println("Enter string:");
                    stIn = in.next();
                    System.out.println("Enter character to count:");
                    cIn = in.next().charAt(0);
                    System.out.println(occurences(stIn, cIn));
                    break;
                    
                case 3:
                    //Remove all occurences of a character
                    System.out.println("Enter string:");
                    stIn = in.next();
                    System.out.println("Enter character to remove:");
                    cIn = in.next().charAt(0);
                    System.out.println(removeOccurences(stIn, cIn));
                    break;
                    
                case 4:
                    //Find all occurences of a substring.
                    System.out.println("Enter string:");
                    stIn = in.next();
                    System.out.println("Enter character to count:");
                    stIn2 = in.next();
                    System.out.println(subOccurences(stIn, stIn2));
                    break;
                    
                case 5:
                    //exit
                    break;
                default:
                    System.out.println("Invalid selection. Try it again.");
            } 
        } while(input != 5);
        
    }
    //helper methods
    static boolean palindrome(String x) {
        //base case 
        if (x.length() < 2) {
            return true;
        }
        //recurse if the first and last are true
        if (x.charAt(0) == x.charAt(x.length() - 1)) {
            return palindrome(x.substring(1, x.length()-1));
        }
        //retun false if the if isnt true. originally had this as an else but that is not necessary
        return false;
        
    }
    
    static int occurences(String x, char y) {
        //base case
        if (x.length() == 0) {
            return 0;
        }
        //recurse and add if they are the same 
        else if (x.charAt(0) == y) {
            return 1 + occurences(x.substring(1, x.length()), y);
        } else 
            //dont add if they arent the same
            return occurences(x.substring(1, x.length()), y);
    }
    
    static String removeOccurences(String x, char y){
        //base case
        if (x.length() == 0) {
            return "";
        }
        
        //check the first char 
        if (x.charAt(0) != y) {
            //if it isnt what we are looking for remove it from the recursion
            return x.charAt(0) + removeOccurences(x.substring(1, x.length()), y);
        } else {
            //only pass on the rest of the string 
            return removeOccurences(x.substring(1, x.length()), y);
        }     
    }
    
    static int subOccurences(String x, String y){
        //base cases
        if (x.length() < 1) {
            return 0;
        }
        if (x.length() < y.length()) {
            return 0;
        }
        
        //check and recurse
        if (x.substring(0, y.length()).equals(y)) {
            //remove first occurence from the string and continue
            return 1 + subOccurences(x.substring(y.length(), x.length()), y);
        }
        //if this isnt the case then remove 1 char and try again
        return subOccurences(x.substring(1, x.length()), y);
    }
}


