package OOP_assignment_2;

public class Matrix {
	
	int[][] matArray;
	int rows, cols;
	
	public Matrix(int rows, int cols){
		
		this.rows=rows;
		this.cols=cols;
		this.matArray=new int[rows][cols];
	}
	
	public int getRow(){return rows;}
	
	public int getCols(){return cols;}
	
	public void setValue(int row,int col,int val){
		
		this.matArray[row-1][col-1]=val;
	}
	
	public int getValue(int row,int col){return matArray[row-1][col-1];}
	
	public void randomize(){
		
		for(int i=0;i<this.rows;i++){
			for(int j=0;j<this.cols;j++){
				
				this.matArray[i][j]=(int) (Math.random()*101);
						
			}
		}
	}
	
	public Matrix add(Matrix a){
		
		Matrix sum=new Matrix(a.rows,a.cols);
		
		if(a.rows==this.rows&&a.cols==this.cols){
			
			for(int i=0;i<this.rows;i++){
				for(int j=0;j<this.cols;j++){
					sum.matArray[i][j]=this.matArray[i][j]+a.matArray[i][j];
				}
			}
			return sum;
		}
		else return null;
	}
	
	public void transpose(){
		
		int tmpp=this.cols;
		this.cols=this.rows;
		this.rows=tmpp;
		
		int[][] tmp=this.matArray;
		this.matArray=new int[this.rows][this.cols];
		
		for(int i=0;i<this.rows;i++){
			for(int j=0;j<this.cols;j++){
				
				this.matArray[i][j]=tmp[j][i];
			}
		}
	}
	
	public Matrix multiply(Matrix a){
		
		if(this.cols==a.rows){
		
			Matrix mul=new Matrix(this.rows,a.cols);
		
			for(int i=0;i<this.rows;i++){
				for(int j=0;j<a.cols;j++){
					int sum=0;
					
					for(int k=0;k<this.cols;k++){
						sum=sum+this.matArray[i][k]*a.matArray[k][j];
					}
					
					mul.matArray[i][j]=sum;
				}
			}
			
			return mul;
		
		}
		else return null;
	}
	
	public boolean equals(Object obj){
		
		if(obj==null) return false;
		else{
			if(getClass()!=obj.getClass()) return false;
			else{
				Matrix otherMat=(Matrix)obj;
				
				if (this.cols==otherMat.cols&&this.rows==otherMat.rows){
					for(int i=0;i<this.rows;i++){
						for(int j=0;j<this.cols;j++){
							
							if(this.matArray[i][j]==otherMat.matArray[i][j]) continue;
							else return false;
						}
					}
					return true;
				}
				else return false;
			}
		}
	}
	
	public String toString(){
		
		String str1="";
		String tmp;
		
		for(int i=0;i<this.rows;i++){
			str1=str1+"[ ";
			for(int j=0;j<this.cols;j++){
				
				tmp=String.format("%5d", matArray[i][j]);
				
				str1=str1+tmp+" ";
			}
			
			str1=str1+" ]\n";
		}
		
		return str1;
	}
}
