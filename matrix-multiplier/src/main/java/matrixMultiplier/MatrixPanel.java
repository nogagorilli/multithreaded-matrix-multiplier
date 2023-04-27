package matrixMultiplier;

import java.awt.*;

import javax.swing.*;

public class MatrixPanel extends JPanel {
	
	
	private class MatrixTextField extends JTextPane{
		private int row;
		private int column;
		public int getColumn() {
			return column;
		}
		public void setColumn(int column) {
			this.column = column;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		MatrixTextField() {
			super();
			this.setSize(new Dimension(25,20));
		}
	}
	
	private int WIDTH;
	private int HEIGHT;
	private MatrixTextField[][] numberFields;
	private int rows;
	private int columns;
	MatrixPanel(int rows,int columns){
		this.columns = columns;
		this.rows = rows;
		this.setLayout(null);
		this.setWIDTH(columns*30+20);
		this.setHEIGHT(rows*30+20);
		this.setSize(new Dimension(this.WIDTH,this.HEIGHT));
		numberFields = new MatrixTextField[rows][columns];
		int num = 1;
		for(int row = 0;row<rows;row++) {
			for(int column = 0;column<columns;column++) {
				MatrixTextField temp = new MatrixTextField();
				temp.setText(Integer.toString(num++));
				temp.setLocation(10+column*30,10+row*30);
				temp.setVisible(true);
				temp.setColumn(column);
				temp.setRow(row);
				this.add(temp);
				this.numberFields[row][column] = temp;
			}
		}
		this.setBackground(new Color(0xcc7722));
	}
	MatrixPanel(Matrix matrix){
		this.columns = matrix.getColumns();
		this.rows = matrix.getRows();
		this.setLayout(null);
		this.setWIDTH(this.columns*30+20);
		this.setHEIGHT(this.rows*30+20);
		this.setSize(new Dimension(this.WIDTH,this.HEIGHT));
		numberFields = new MatrixTextField[this.rows][this.columns];
		this.setBackground(new Color(0xcc7722));
		for(int row = 0;row<matrix.getRows();row++) {
			for(int column = 0;column<matrix.getColumns();column++) {
				MatrixTextField temp = new MatrixTextField();
				temp.setLocation(10+column*30,10+row*30);
				temp.setVisible(true);
				temp.setColumn(column);
				temp.setRow(row);
				temp.setText(Integer.toString(matrix.getMatrix()[row][column]));
				this.add(temp);
				this.numberFields[row][column] = temp;
			}
		}
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	public Matrix getMatrix() {
		Matrix matrix;
		matrix = new Matrix(rows,columns);
		for(MatrixTextField[] fieldRow:this.numberFields) {
			for(MatrixTextField field:fieldRow) {
				try {
					matrix.getMatrix()[field.getRow()][field.getColumn()] = Integer.parseInt(field.getText());
				}catch(NumberFormatException ex) {
					matrix.getMatrix()[field.getRow()][field.getColumn()] = 0;
				}
			}
		}
		return matrix;
	}
	
}
