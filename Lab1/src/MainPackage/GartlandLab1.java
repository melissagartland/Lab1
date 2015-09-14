/*
 * Name: Melissa Gartland and Kayla Gustafson
 * Title: Lab 1
 * Date: 9/12/2015
 * Description: program takes user information to calculate how much will need to be 
 * saved to live after retirement.
 * Input: years to work, percent annual return, years retired, new annual return, required
 * income and monthly SSI
 * Output: how much to save per month before retirement and total amount that needs to be saved
 * for a given time period (ie how long one lives after retirement).
 */

package MainPackage; 

import org.apache.poi.ss.formula.functions.FinanceLib; //import FinanceLib
import java.util.Scanner; //import scanner


public class GartlandLab1
{
	private static Scanner kb;

	public static void main(String[] args)

	{
		kb = new Scanner(System.in);
		
		System.out.println("Please enter the following information."); //prompt user to enter information
	
		//PV calculations
		
		double yearsRetired; //use for n calculation; n = yearsRetired * 12
		System.out.print("Years retired: ");
		yearsRetired = kb.nextDouble();
		
		double annualReturn; //use for r calculation; r = annualReturn * 12
		System.out.print("Percent annual return as a decimal: ");
		annualReturn = kb.nextDouble();
		
		double requiredIncome; //use for y calculation; y = requiredIncome - monthlySSI
		System.out.print("Required monthly income: ");
		requiredIncome = kb.nextDouble();
		
		double monthlySSI; 
		System.out.print("Monthly Social Security Income: "); //use for y calculation
		monthlySSI = kb.nextDouble();
		
		double PV; 
		
		double f = 0;
		boolean t = false;
		double n = yearsRetired*12;
		double r = annualReturn/12;
		double y = requiredIncome - monthlySSI;
		
		PV = FinanceLib.pv(r, n, y, f, t); //PV calculation formula; will output total amount to be saved
		System.out.println("Total to be saved: " + PV);
		
		//PMT calculations
		double PMT;
		
		System.out.print("Adjusted percent annual return as decimal: "); 
		annualReturn = kb.nextDouble(); //new r value
		
		System.out.print("Years left in work: ");
		double yearsLeft = kb.nextDouble(); //new n value
		
		r = annualReturn/12;
		n = yearsLeft*12;
		double p = 0;
		f = PV;
		t = false;
		
		PMT = FinanceLib.pmt(r, n, p, f, t);  //PMT caclulation formula; will out put the monthly total to be saved
		System.out.println("Monthly amount to be saved: " + PMT);
		
		 	
	}

}
