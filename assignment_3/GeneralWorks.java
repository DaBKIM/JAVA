package OOP_assignment_3;

public class GeneralWorks extends LibraryItem implements Lonable{

	public GeneralWorks(String id,String title,String author){
		
		super(id,title,author,5);
	}

	public boolean loanItem(){
		
		if(this.getAvailableUnits()>0){
			
			int tmp=this.getAvailableUnits();
			tmp--;
			this.setAvailableUnits(tmp);
			return true;
		}
		else return false;
	}
	
	public boolean returnItem(){
		
		int tmp=this.getAvailableUnits();
		
		if(tmp<5){
			tmp++;
			this.setAvailableUnits(tmp);
			return true;
		}
		else return false;
	}
}
