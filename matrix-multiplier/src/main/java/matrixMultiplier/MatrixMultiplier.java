package matrixMultiplier;

import java.util.ArrayList;

public class MatrixMultiplier{
	
	static Matrix multiply(Matrix matrix1,Matrix matrix2) throws MatrixException{
		if(matrix1.getColumns() != matrix2.getRows()) throw new MatrixException();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Matrix ret;
		ret = new Matrix(matrix1.getRows(), matrix2.getColumns());
		for(int row = 0;row<ret.getRows();row++) {
			for(int column = 0;column<ret.getColumns();column++) {
//				int val = 0;
//				for(int i = 0;i<matrix1.getColumns();i++) {
//					val+=(matrix1.getMatrix()[row][i]*matrix2.getMatrix()[i][column]);
//				}
//				ret.getMatrix()[row][column] = val;
				DotMultiplier task = new DotMultiplier(matrix1,matrix2,ret,row,column); 
				Thread thread = new Thread(task);
				thread.start();
				threads.add(thread);
			}
		}
		return ret;
	}
	static private class DotMultiplier implements Runnable{
		Matrix matrix1;
		Matrix matrix2;
		Matrix result;
		int row1;
		int col2;
		
		DotMultiplier(Matrix m1,Matrix m2,Matrix result, int row1,int col2) {
			this.matrix1 = m1;
			this.matrix2 = m2;
			this.result = result;
			this.row1 = row1;
			this.col2 = col2;
		}
		
		public void run() {
			int val = 0;
			for(int i = 0;i<this.matrix1.getColumns();i++) {
				val+=(matrix1.getMatrix()[row1][i]*matrix2.getMatrix()[i][col2]);
			}
			this.result.getMatrix()[row1][col2] = val;
			System.out.println("row " + Integer.toString(row1)+" Column " + Integer.toString(col2) + " val " + Integer.toString(val));
		}
		
	}
}
