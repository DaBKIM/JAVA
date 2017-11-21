package OOP_assignment_2;

public class SquareMatrix extends Matrix {
	
	private int dim;
	
	public SquareMatrix(int dim){
		
		super(dim,dim);
		this.dim=dim;
	}
	
	public int getDim(){return dim;}
	
	public boolean isDiagonal(){
		
		for(int i=0;i<this.dim;i++){
			for(int j=0;j<this.dim;j++){
				if(i==j){
					if(this.matArray[i][j]!=0) continue;
					else return false;
				}
				else{
					if(this.matArray[i][j]!=0) return false;
					else continue;
				}
			}
		}
		return true;
	}
	
	public SquareMatrix identity(){
		
		SquareMatrix sq=new SquareMatrix(this.dim);
		
		for(int i=0;i<sq.dim;i++){
			for(int j=0;j<sq.dim;j++){
				if(i==j) sq.matArray[i][j]=1;
				else sq.matArray[i][j]=0;
			}
		}
		
		return sq;
	}
	
}
