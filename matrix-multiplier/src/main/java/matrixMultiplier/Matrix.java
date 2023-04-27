package matrixMultiplier;

public class Matrix {
	private int[][] matrix;
	private int rows;
	private int columns;
	Matrix(int rows,int columns){
		this.matrix = new int[rows][columns];
		this.setRows(rows);
		this.setColumns(columns);
	}
	public int[][] getMatrix(){
		return this.matrix;
	}
	public int getRows() {
		return rows;
	}
	private void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	private void setColumns(int columns) {
		this.columns = columns;
	}
	
	
}
