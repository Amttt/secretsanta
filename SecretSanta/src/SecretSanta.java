/*
 * Written by Ann-Marie Thompson
 */
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class SecretSanta {
	/*
	 * A simple program that acts as a Secret Santa generator. Takes an input of participant names and randomly pairs each participant with another.
	 */
	private static final int DEFAULT = 3;
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random(); // Random seed
		int receiver_generator = r.nextInt(DEFAULT); // Create random generator variable
		String[] participants = new String[DEFAULT]; 
		String[] givers = new String[DEFAULT]; 
		String[] receivers = new String[DEFAULT]; 
		ArrayList<Integer> usedNum = new ArrayList<Integer>(DEFAULT); // Create array list containing the used pairing value
		
		System.out.println("Enter the names of participants."); // Ask for input of participants
		String participant = ""; // Initialize participant
		// Begin populating the participant and givers array
		boolean initialized = false;
		while(initialized == false) {  
			for(int i=0;i<DEFAULT;i++)
			{
				participant = keyboard.nextLine();
				participants[i] = participant;
				givers[i] = participants[i];
			}
			initialized = true; // Done populating the givers array
		}
		keyboard.close();
		// Begin pairing participants
		boolean paired = false;
		while(paired == false) 
		{
			for(int i=0;i<receivers.length;i++) {
				while(usedNum.contains(receiver_generator)) // Prevent duplicate receivers
					receiver_generator = r.nextInt(DEFAULT);
				receivers[i] = givers[receiver_generator];
				if(givers[i].equals(receivers[i])) // Prevent receiver and giver being the same person
				{
					receiver_generator = r.nextInt(DEFAULT);
					receivers[i] = givers[receiver_generator];
				}
				usedNum.add(receiver_generator);
				receiver_generator = r.nextInt(DEFAULT);
			}		
			paired = true; // Pairing has been completed
		}			
		// Print out the list of givers and receivers
		for(int i=0;i<givers.length;i++) 
			System.out.println("Giver: " + givers[i] + " Receiver: " + receivers[i]);
	}
}