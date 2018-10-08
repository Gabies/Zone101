# Zone101
The Driver class for Ticket data element class. 
/**
 * @ Gabriella
 */
 
import java.util.Scanner;
public class TicketDriver {


	public static void main(String[] args) {

		String name, schoolz, workz, nextTicket;
		int speed,speedlmt;
		boolean schoolZone = false; boolean workZone = false ;

		//create a variable of class Ticket. 
		Ticket violator;

		Scanner input = new Scanner(System.in);

		// A do - while loop that prints the whole ticket information.

		do {
			System.out.println("Ticket Manager");
			System.out.println("\n");

			// Enter the name

			System.out.print("Enter the name of the violator: ");
			name = input.nextLine();

			// Enter the speed and validate the speed to be greater than 0.
			do {
				System.out.print("Enter the speed of the violator (>0): ");
				speed = input.nextInt();
			} while(speed < 0 );


			//Enter the speed limit and validate it if it is between 0 and 80.

			do {
				System.out.print("Enter the speed limit (>0, <=80): ");
				speedlmt = input.nextInt();
			} while(speedlmt <0 || speedlmt >80 );

			// Ask and validate if it is either a school zone or not. 
			do {
				System.out.print("Was this in a school Zone? (Y/N): ");
				input.nextLine();
				schoolz = input.nextLine();
				if (schoolz.equalsIgnoreCase("Y")) {
					schoolZone = true;
				}
			}
			while (!(schoolz.equalsIgnoreCase("Y"))  && !(schoolz.equalsIgnoreCase("N")));


			do {
				System.out.print("Was this in a work Zone? (Y/N): ");

				workz = input.nextLine();

				if (workz.equalsIgnoreCase("Y")) {
					workZone = true;
				}
			}
			while (!(workz.equalsIgnoreCase("Y"))  && !(workz.equalsIgnoreCase("N")));

			// Creating an object.
			violator = new Ticket(name, speed, speedlmt, workZone, schoolZone);

			violator.setName("Mark");
			System.out.println();

			System.out.println( violator.printNotice());

			System.out.println("Do you want to enter another ticket? (Y/N): ");
			nextTicket = input.nextLine();
		}
		while (nextTicket.equalsIgnoreCase("Y"));
		System.out.println("Exiting the Ticket Manager.");

	}


}
