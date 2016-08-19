
import java.util.Scanner;
public class Unit5PgmLab2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int month;
		boolean repeat = false;
		do
		{
			repeat = false;
			System.out.print("\nEnter a month (1-12): ");
			month = input.nextInt();
			if ((month > 12) || (month < 1))
			{
				System.out.println("Invalid month");
				repeat = true;
			}
		}
		while (repeat);	
		System.out.print("Enter a year: ");
		int year = input.nextInt();	
		
		//display the monthly calendar
		System.out.println("\n");
		printMonthCalendar(month, year);
		System.out.println("\n");

		input.close();
	}

	// method for printing a calculator for the month and year
	public static void printMonthCalendar( int m, int y )
	{
		printMonthHeader(m, y);
		printMonthBody(m, y);

	}

	// method to print the header information
	public static void printMonthHeader( int m, int y )
	{
		String monthName = getMonthName(m);
		System.out.println("         "+monthName+"  "+y);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	// method for printing the body information
	public static void printMonthBody( int m, int y )
	{
		int day = getStartDay(m,1,y);
		int numDays = getNumDaysinMonth(m, y);

		int startNum = 1;
		int startPos;
		if (day == 7)
			startPos = 0;
		else
			startPos = day;

		do
		{
			//loop for each row in the display
			for (int j=0; j<7 && startNum <= numDays; j++)
			{
				//loop for each column in the display
				if ((startNum == 1) && (j < startPos))
					System.out.printf("    ");
				else
				{
					System.out.printf("%4d",startNum);
					startNum++;
				}

			}
			System.out.println("");
			
		}while(startNum < numDays);

	}

	// method for getting the number of days in the month
	public static int getNumDaysinMonth( int m, int y )
	{
		int numDays = 0;
		if ((m <= 12) && (m >= 1))
		{
			if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12))
				numDays = 31;
			else if (m == 2)
			{
				if (isLeapYear(y)==true)
					numDays = 29;
				else
					numDays = 28;
			}
			else
				numDays = 30;

		}
		return numDays;
	}

	
	// method returns true if it is a leap year
	public static boolean isLeapYear( int y )
	{
		boolean leapYear = false;
		if ((y % 4) == 0)
			leapYear = true;

		return leapYear;
	}

	// method for getting the name of the month
	public static String getMonthName(int m)
	{
		String name="";
		switch (m)
		{
		case 1:
			name = "January";
			break;

		case 2:
			name = "February";
			break;
		case 3:
			name = "March";
			break;
		case 4:
			name = "April";
			break;

		case 5:
			name = "May";
			break;

		case 6:
			name = "June";
			break;

		case 7:
			name = "July";
			break;

		case 8:
			name = "August";
			break;

		case 9:
			name = "September";
			break;

		case 10:
			name = "October";
			break;

		case 11:
			name = "November";
			break;

		case 12:
			name = "December";
			break;
		default:  
			name = "Error";
			break;
		}
		return name;
	}

	/*
	  The method getStartDay() implements Zeller's Algorithm for determining the day of the
	  week the first day of a month is. The method adjusts Zeller's numbering scheme
	  for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
	  that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)

	  Pre-Conditions: The month value, m,  is 1-12
	                        The day value, d, is 1-31, or 1-28, 1-29 for February
	                        The year value, y, is the full year (e.g., 2012)

	 Post-Conditions: A value of 1-7 is returned, representing the first day of the month
	                        1 = Monday, ..., 7 = Sunday
	 */

	// method for getting the start day
	public static int getStartDay( int m, int d, int y )
	{
		// Adjust month number & year to fit Zeller's numbering system
		if ( m < 3 ) 
		{
			m = m + 12;
			y = y - 1;
		}

		int k = y % 100;      // Calculate year within century
		int j = y / 100;      // Calculate century term
		int h = 0;            // Day number of first day in month 'm'

		h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 * j ) ) % 7;

		// Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
		int dayNum = ( ( h + 5 ) % 7 ) + 1;     

		return dayNum;
	}

}
