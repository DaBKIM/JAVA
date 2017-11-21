package OOP_assignment_2;

public class Vector extends Matrix {
	
	private int dim;
	
	public Vector(int dim){
		
		super(1,dim);
		this.dim=dim;
	}
	
	public int getDim(){return dim;}
	
	public Vector multiply(Matrix a){
		
		if(getClass()==a.getClass()){
			a.transpose();
		
			if(this.cols==a.rows){
			
				Vector vec=new Vector(this.rows);
		
				for(int i=0;i<this.rows;i++){
					for(int j=0;j<a.cols;j++){
						int tmp=0;
						for(int k=0;k<this.cols;k++){
							tmp=tmp+this.matArray[i][k]*a.matArray[k][i];
						}
					
						vec.matArray[i][j]=tmp;
					}
				}
				return vec;
			}
			else return null;
		}
		else return null;
	}
}
