package OOP_assignment_1;

import java.util.Scanner;

public class expCalculator {
	
	public static double x=1.0;
	public static double n=10.0;
	
	public static double pow(double x, double n){
		
		double powing=1;
		int i=0;
		
		for(i=0;i<n;i++){
			
			powing*=x;
		}
		
		return powing;
	}
	
	public static double fac(double n){
		
		double factorial=1;
		int j=1;
		
		for(j=1;j<=n;j++){
			
			factorial*=j;
		}
		
		return factorial;
	}
	
	public static double exp(double x, double n){
		
		double expansion=0;
		int z=0;
		for(z=0;z<=n;z++){
			expansion+=pow(x,z)/fac(z);
		}
		
		return expansion;
		
	}
	
	public static void main(String[] args){
		
		Scanner key=new Scanner(System.in);
		String tmp,free=null;
		
		while(true){
			
			System.out.println("===============Main Menu===============");
			System.out.println("(1) Change x from current value : "+x);
			System.out.println("(2) Change n from current value : "+n);
			System.out.println("(3) Calculate exp");
			System.out.println("(4) Exit the program");
			System.out.println("===============Main Menu===============");
			
			tmp=key.nextLine();
			
			if(tmp.equals("1")){
				System.out.println("The a value for x:");
				x=key.nextDouble();
				free=key.nextLine();
			}
			else if(tmp.equals("2")){
				
				System.out.println("The a value for n:");
				n=key.nextDouble();
				free=key.nextLine();
			}
			else if(tmp.equals("3")){
				
				System.out.println("The a value for e^"+x+" is : "+exp(x,n));
				System.out.println();
			}
			else if(tmp.equals("4")) {
				
				System.out.println("Program Exit!");
				return;
				
			}
			else{
				System.out.println("Please choose the number in the menu!");
			}
			
			
		}
	}
}
