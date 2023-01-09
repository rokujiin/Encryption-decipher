
import java.util.*;
public class  EncryptHalili
{

}
class MessageEncryptor
{
    public static void main(String[] args) {

        takeUserInput();

    }

    public static void takeUserInput()
    {
        //create scanner object
        Scanner input = new Scanner(System.in);

        //create for loop to loop 20 times
        for(int i = 0; i < 20; i++){

            //display menu
            menu();

            //ask the user to enter the choice and store it in a variable.
            System.out.println("Enter your choice: ");
            String choice = input.next();
            // If the user’s input is not a valid option, then continue with the next iteration of the loop
            if(!(choice.equalsIgnoreCase("E") || choice.equalsIgnoreCase("D")|| choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("d"))){
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            //ask the user to enter a message store it in a variable
            System.out.println("Enter a message: ");
            input.nextLine();
            String message;
            message = input.nextLine();

            //ask the user to enter a key and store it in a variable. If negative say invalid key then continue to next iteration
            System.out.println("Enter a key");
            int key = input.nextInt();
            if(key < 0){
                System.out.print("Invalid key");
                continue;
            }

            //if the user entered e or E then call method2. pass the message and key as parameters return the encrypted message and store it in a variable
            if(choice.equals("e") || choice.equals("E")){
                String encryptedMessage = encrypt(message, key);
                System.out.println(encryptedMessage);
            }
            //if the user entered d or D then call method3. pass the message and key as parameters return the decrypted message and store it in a variable
            else if(choice.equals("d") || choice.equals("D")){
                String decryptedMessage = decrypt(message, key);
                System.out.println(decryptedMessage);
            }
        }
    }

    /*
     * Returns a new string with the letters of the given string shifted
     * forward or backward by the amount equal to the given key.
     */
    public static String encrypt(String s, int key)
    {
        //convert the string to uppercase using toUpperCase() method
        s = s.toUpperCase();
        //create a string variable to store the encrypted message
        StringBuilder encryptedMessage = new StringBuilder();
        //create a for loop to loop through the string
        for(int i = 0; i < s.length(); i++)
        {
            //get each letter in the variable s and store it in a variable type char using the charAt() method. If the letter = '' then replace it with '#'
            char letter = s.charAt(i);
            if(letter == ' ')
            {
                letter = '#';
            }
            else
            {
                //if the key is between 'a' and 'z' then add the key to the letter
                if(letter >= 'A' && letter <= 'Z')
                {
                    letter = (char)(letter + key);
                    //check if the letter is greater than 'Z' then subtract 26 from the letter
                    if(letter > 'Z')
                    {
                        letter = (char)(letter - 26);
                    }
                    else if(letter < 'A')
                    {
                        letter = (char)(letter + 26);
                    }
                }
            }
            //add the letter to the encrypted message
            encryptedMessage.append(letter);
        }
        return encryptedMessage.toString();
    }
    /*
     * decrypts the encrypted string using the same key value.
     */
    public static String decrypt(String s, int key)
    {
        //declare a string variable to store the decrypted message
        StringBuilder decryptedMessage = new StringBuilder();
        //create a for loop to loop through the string s
        for(int i = 0; i < s.length(); i++)
        {
            //get each letter in the variable s and store it in a variable type char using the charAt() method. replace '#' with spaces
            char letter = s.charAt(i);
            if(letter == '#')
            {
                letter = ' ';
            }
            else
            {
                //if the letter is between 'a' and 'z'
                if(letter >= 'A' && letter <= 'Z')
                {
                    //subtract the key from the letter
                    letter = (char)(letter - key);
                    //check if the letter is less than 'A' then add 26 to the letter
                    if(letter < 'A')
                    {
                        letter = (char)(letter + 26);
                    }
                    else if(letter > 'Z')
                    {
                        letter = (char)(letter - 26);
                    }
                }
            }
            //concatenate the letter to the decrypted message
            decryptedMessage.append(letter);
        }
        return decryptedMessage.toString();
    }

    /*This method displays a menu for the user to choose the option.*/
    public static void menu()   //<-------  must change the name method4 to a name of your choice
    {
        for(int i = 0; i < 50; i++)
        {
            System.out.print("^");
        }
        System.out.println("\nWelcome to the Caesar Cipher Program!");
        System.out.println("Please choose one of the following options:");
        System.out.println("Enter 'E' or 'e' to encrypt a message.");
        System.out.println("Enter 'D' or 'd' to decrypt a message.");
        for(int i = 0; i < 50; i++)
        {
            System.out.print("^");
        }
        System.out.println();
    }
}
