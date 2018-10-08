import java.util.Random;
import java.text.Format;
import java.text.NumberFormat;
public class Ticket {

	private String name, notice;
	private int speed;
	private int speedLimit;
	private boolean workZone;
	private boolean schoolZone;
	private double fine = 0;

	
	public Ticket() {
		this.name= name;
		this.speed = speed;
		this.speedLimit= speedLimit;
	
	}
	/**
	 * Constructor that takes data as input and sets them.
	 * @param name the name of the violator.
	 * @param speed the speed of the violator.
	 * @param speedLimit the speedLimit of the region.
	 * @param workZone the work zone region where the driver passed the speed limit.
	 * @param schoolZone the school zone region where the driver passed the speed limit. 
	 */
// Correction switch the workZone and school zone order 
	public Ticket(String name,int speed, int speedLimit,boolean schoolZone, boolean workZone) {
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.workZone = workZone;
		this.schoolZone = schoolZone;
	}

	/**
	 * 
	 * @param name the name of the violator.
	 * @param speed the speed of the violator.
	 * @param speedLimit the speedLimit of the region.
	 */

	public Ticket(String name,int speed, int speedLimit) {
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		workZone = false;
		schoolZone = false;
	}

	/**
	 * sets name of the violator
	 * @param name the name of the violator
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  returns the name
	 * @return the name of the violator
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the speed 
	 * @param speed the speed of the violator
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * returns the speed
	 * @return the speed of the 
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * sets the speed limit 
	 * @param speedLimit the speed limit of the region
	 */

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}
	
	/**
	 * returns the speed limit 
	 * @return speed limit of the area
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	/**
	 * sets the school zone
	 * @param schoolZone the school zone where the driver was violating 
	 */
	public void setSchoolZone(boolean schoolZone) {
		this.schoolZone = schoolZone;
	}


	/**
	 * returns the school zone
	 * @return school Zone  where the driver was violating 
	 * 
	 */
	public boolean isSchoolZone() {
		return schoolZone;

	}
	
	/**
	 * sets the work zone
	 * @param workZone where the driver was violating
	 */
	public void setWorkZone(boolean workZone) {
		this.workZone = workZone;
	}

	/**
	 * returns the work Zone
	 * @return work zone where the violator was driving
	 */
	public boolean isWorkZone() {
		return workZone;
	}

	/**
	 * returns the amount to be charged
	 * @return fine to be made
	 */
	public double calculateFine() {
		double overLimit;
		overLimit = speed - speedLimit;


		if(overLimit>=1 && overLimit<=10) {
			fine = 140.00;
			if (schoolZone == true ) {
				fine +=60.00;
			}
			else if (workZone == true ) {
				fine +=110.00;
			}
		}
		else if (overLimit>=11 && overLimit <= 30) {
			fine = 195;
			if (overLimit >=21) {
				fine += 300.00;			
			}
			if (workZone) {
				fine +=165.00;
			}
			else if (schoolZone) {
				fine +=115.00;
			}

		}
		else if (overLimit >= 31){
		
			if (overLimit<41) {
				fine = 450.00;
			}
			else if (overLimit >=41){
				fine = 675.00;
			}
		}return fine;
	}

	/**
	 * returns the region where the driver passed the over limit.
	 * @return place 
	 */
	public String place() {
		String place;
		if (schoolZone == true) {
			place =  "school zone";
		}else if (workZone == true) {
			place = "work zone";
		}else 
			place =  "Zone";
		return place;
	}
	/**
	 * returns additional string for clarification
	 * @return string
	 */
	public String clarification() {
		double overLimit;
		//String clarify = "";
		overLimit = speed - speedLimit;
		if (overLimit > 30) {
			return "\r\nYou must appear at the County Court House on October " + generateCourDate() + ", 2018." ;
		}
		return " ";
	}
	/**
	 * prints out the format of the ticket
	 * @return print
	 */
	public String printNotice() {  
		Format fmt = NumberFormat.getCurrencyInstance();
		notice = "Department of Motor Vehicles\r\n" + 
				"Automated Traffic Enforcement\r\n" + 
				"\r\n" + 
				"\r\n" +
				"Dear " + name + ",\r\n" + 
				"\r\n" + 
				"Please pay the following speeding fine of " + fmt.format(calculateFine()) + " to the DMV within 10 days of\r\n" + 
				"receiving this notice to avoid a driver's license suspension. You are being fined for going " + speed + " MPH in a " + 
				speedLimit + " MPH " + place()  + ". \r\n" +
				"\r\n" + 
				"Ticket Type:"+ ticketType() +
				clarification() + "\r\n" +
				"Ticket Number: " + generateTicketNum() + ".\r\n" + 
				"\r\n" + 
				"Returned checks are subject to a returned check fee of $35.00\r\n" + 
				"\r\n" +  
				"Sincerely\r\n" + 
				"Gabriella S.T. \r\n" + 
				"";

		return notice;
	}


	Random ran = new Random();
	/**
	 * generates a random number
	 * @return an integer value of random number
	 */
	private int generateTicketNum(){ 
		return  ran.nextInt((999999 - 100000)+ 1) + 100000; // very cool formula
	}
	/**
	 * prints out random date
	 * @return date
	 */
	private int generateCourDate() {    

		return ran.nextInt((31) +1 );

	}
	/**
	 * the kind of ticket
	 * @return the type of ticket
	 */

	private  String ticketType( ) {
		double overLimit;
		overLimit = speed - speedLimit;
		String type = " ";
		if (overLimit <= 30) {
			type = "PAYABLE";
		} 
		if (overLimit >30) {
			type =  "MUST APPEAR";
		}
		return type ;
	}
	/** 
	 * returns ticket type
	 * @return ticket type
	 */
	public String getTicketType() {
		return ticketType();
	}
	/**
	 * to string
	 */
	public String toString() {
	
		return (this.name + this.speed + this.speedLimit + ticketType()
		+ generateTicketNum());
	}







}
