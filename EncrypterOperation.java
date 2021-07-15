import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncrypterProgram {
private Scanner scanner;
private Random random;
private ArrayList<Character> list;
private ArrayList<Character> shuffledList; 
private char character;                                  // individual characters to be added to array key
private char letters[];                                  // Use to hold char in an array
private boolean keyIsEmpty;
	
	EncrypterProgram(){
		scanner      = new Scanner(System.in);               // Use to type user input
		random       = new Random();                         // To randomize the list and make it encrypted
		list         = new ArrayList<Character>();           // The list that will generate the Character keys
		shuffledList = new ArrayList<Character>();           // The list that will be randomized
		character = ' '; 
		keyIsEmpty = true;                                  // Check if key is empty
		askQuestion();
	}
	
	/*
	 * The askQuestion() Method: Calls in the users to press a key to call a command
	 *    Uses a switch to call individual methods(Actions)
	 *    The char response variable: Uses the class Character .toUpperCase() method to automatically convert that characters
	 *    to all upper case. The Scanner nextLine() gets the user input and the charAt() method reads the first character
	 *    of the user input: (N)ext or (n)ext ---> (N) case 'N'
	 */
	private void askQuestion() {
		while(true) {
			System.out.println();
			System.out.println("********************************************************************");
			System.out.println("Type in the keys to perform actions");
			System.out.println(" N: New Key \n G: Get Key \n E: Encrypt \n D: Decrypt \n Q: Quit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
				default:
					System.out.println("Invalid Input, Please try another input");
			}
		}
	}
	
	/*
	 * the newKey() Method: creates a new key for the user to use, clears the old key
	 *     Clears the list and shuffledList 
	 *     the for loop add the Characters of ASCII 32 through 127. It then add each character
	 *     to the list. It then increases the value of the character add a new character till
	 *     the character stops at 126
	 *     Creates a new list(ArrayList) called shuffledList and is shuffled by the 
	 *     Collections.shuffle() class method
	 *     The both list and shuffledList are printed
	 *     
	 */
	private void newKey() {
		keyIsEmpty = false;
		System.out.println("------------------------------------------------");
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i = 32; i < 127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList<Character>(list);
		Collections.shuffle(shuffledList);
		System.out.println("New key has been successfully made :)");
		System.out.println("List:         " + list + "\n" + "Shuffle List: " + shuffledList);
		
			
			
		
	}
	/*
	 * The getKey() Method: Prints out the list and shuffledList
	 *     By using the Enhanced for loop to go thru the list & shuffledList and print each element
	 */
	private void getKey() {
		if(keyIsEmpty == true) {
			System.out.println("Please Try New Key: Type N to get new key");
		}
		else if(keyIsEmpty == false) {
			
		System.out.println("Key: ");
		for(char x: list) {
			System.out.print( x);
			
		}
		System.out.println();
		for(char x: shuffledList) {
			System.out.print(x);
		}
		}
	}
	/*
	 * the encrypt() method: creates an encrypted key for the user, by encrypting a user's input
	 *      It will ask the user to type an input. This input will be assign to the String: message
	 *      Then the message string is assign to the char array letters[] but first the message
	 *      calls a method .toCharArray() which converts the string message to individual characters
	 *      and put it in a array. The conversion is needed for it be assigned to letters[]
	 *      
	 *      The second operation is that we use a for loop to read go thru each letter and the length of
	 *      letters[]. Then a nested loop to go thru each letter of the shuffledList size. 
	 *      The operation is for the literation to go through list and find the match character from
	 *      the letter[i] provided by the user input. Once the letter is found the same index of
	 *      list will be used to get the shuffledList character from the same index and assign
	 *      the character to letter[i]
	 *      
	 *      Once complete the encrypted key is printed
	 *      
	 */
	private void encrypt() {
		System.out.println("Type something to encrypt");
		String message = scanner.nextLine();
		letters = message.toCharArray();
		
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < shuffledList.size(); j++) {
				if(letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		for(char x: letters) {
			System.out.print(x);
		}
		System.out.println();
		System.out.println("Key has been successfully encrypted >:]");
	}
	/*
	 *  the decrypt() method: will decrypt the encryption message to its original  and print it
	 *       A nested loop is used to go through the length of letters[] user input.
	 *       Literate through the shuffledList size. Uses the index of letters[i] to go thru
	 *       each character and find its matching pair in the shuffledList
	 *       Once matching pair is found, it assigns the shuffledList index number to list(j)
	 *       and adds that value to the letters[i] index.
	 *       
	 *       Prints the characters of letter[]
	 */
	private void decrypt() {
		System.out.println("Decrypting Key please wait...." + "\n");
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0 ; j < shuffledList.size() ; j++) {
				if(letters[i] == shuffledList.get(j)) {
					
					letters[i] = list.get(j);
					break;
				}
			}
		}
		for(char x: letters) {
			System.out.print(x);
		}
	}
	/*
	 * The quit() Method: Good bye message and operation to exit program.
	 */
	private void  quit() {
		System.out.println("Good Bye Old Friend.....");
		System.exit(0);
	}
	
}
