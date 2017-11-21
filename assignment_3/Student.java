package OOP_assignment_3;

import java.util.*;

public class Student implements Comparable<Object> {
	
	private String name;
	private String id;
	private int numLoans;
	private int numReserves;
	
	HashSet<GeneralWorks> onLoan;
	HashSet<ReservedWorks> onReserve;
	
	public Student(String name,String id){
		this.name=name;
		this.id=id;
		this.numLoans=0;
		this.numReserves=0;
		
		onLoan=new HashSet<GeneralWorks>();
		onReserve=new HashSet<ReservedWorks>();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getNumLoans() {
		return numLoans;
	}

	public int getNumReserves() {
		return numReserves;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		else if (getClass() != obj.getClass()) return false;
		else {
			Student other = (Student) obj;
			return this.id.equals(other.id);
		}
		
	}
	
	public int compareTo(Object obj){
		
		if(obj==null) throw new NullPointerException("The object is null.");
		if(this.getClass()!=obj.getClass()) throw new ClassCastException("The object is not of the same type.");
		Student other=(Student) obj;
		return this.id.compareTo(other.id);
	}
	
	public String toString(){
		
		String str="============Student Record============\n"+"Name: "+this.name+"\n"+"id number: "+this.id+"\n"
				+"onLoan: "+this.numLoans+"\n"+"onReserve: "+this.numReserves+"\n"
				+"------------onloan------------\n";
		
		
		for(GeneralWorks it:onLoan){
			
			str+=it.toString();
		}
		str+="------------onreserve------------\n";
		for(ReservedWorks it_2:onReserve){
			
			str+=it_2.toString();
		}
		str+="=====================================\n";
		
	    return str;
				
	}
	
	public boolean acquireItem(LibraryItem obj){
		
		ReservedWorks t=new ReservedWorks("1","tmp","tmp");
		
		if(obj.getClass()==t.getClass()){
			if(!onReserve.contains(obj)){
		
				ReservedWorks tmp=(ReservedWorks)obj;
				if(tmp.reserveItem()==false) return false;
				else {
					this.numReserves++;
					onReserve.add(tmp);
					return true;
				}
			}
			else return false;
		}
		else{
			if(!onLoan.contains(obj)){
			
				GeneralWorks tmp=(GeneralWorks)obj;
				if(tmp.loanItem()==false) return false;
				else{
					this.numLoans++;
					onLoan.add(tmp);
					return true;
				}
			}
			else return false;
		}
	}
	
	public boolean releaseItem(LibraryItem obj){
		
		
		if(obj.returnItem()==true){
			
			if(onReserve.contains(obj)){
				onReserve.remove(obj);
				this.numReserves--;
				return true;
			}
			else if(onLoan.contains(obj)){
				onLoan.remove(obj);
				this.numLoans--;
				return true;
			}
			else return false;
		}
		else return false;
	}
	
}
