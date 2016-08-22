
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
		
		System.out.println("\n");
		printMonthCalendar(month, year);
		System.out.println("\n");

		input.close();
	}

	public static void printMonthCalendar( int m, int y )
	{
		printMonthHeader(m, y);
		printMonthBody(m, y);

	}

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
			for (int j=0; j<7 && startNum <= numDays; j++)
			{
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



	public static int getStartDay( int m, int d, int y )
	{
		if ( m < 3 ) 
		{
			m = m + 12;
			y = y - 1;
		}

		int k = y % 100;      
		int j = y / 100;      
		int h = 0;            

		h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 * j ) ) % 7;

	
		int dayNum = ( ( h + 5 ) % 7 ) + 1;     

		return dayNum;
	}

}
