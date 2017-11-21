package OOP_assignment_3;

public class ReservedWorks extends LibraryItem implements Reservable {
	
	public ReservedWorks(String id,String title,String author){
		
		super(id,title,author,1);
	}
	
	public boolean reserveItem(){
		
		int tmp=this.getAvailableUnits();
		
		if(tmp>0){
			tmp--;
			this.setAvailableUnits(tmp);
			return true;
		}
		else return false;
	}
	
	public boolean returnItem(){
		
		int tmp=this.getAvailableUnits();
		
		if(tmp==0){
			tmp++;
			this.setAvailableUnits(tmp);
			return true;
		}
		else return false;
		
	}
}
