package matrixMultiplier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MatrixGUI extends JFrame{
	private MatrixPanel firstMatrixPanel;
	private MatrixPanel secondMatrixPanel;
	private MatrixPanel resultingMatrixPanel;
	private JTextField firstRows;
	private JTextField firstColumns;
	private JTextField secondRows;
	private JTextField secondColumns;
	private JButton multiplyButton;
	MatrixGUI(){
		super("Matrix multiplication");
		this.setLayout(null);
		this.setSize(new Dimension(800,500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(0xcc7722));
		this.firstMatrixPanel = new MatrixPanel(1, 2);
		this.secondMatrixPanel = new MatrixPanel(2, 1);
		this.resultingMatrixPanel = new MatrixPanel(5,5);
		this.firstRows = new JTextField();
		this.firstRows.setSize(new Dimension(60,20));
		this.firstRows.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("aaaaaaaaaa");
				try {
					int num = Integer.parseInt(firstRows.getText());
					updateFirstMatrixPanel(num,firstMatrixPanel.getMatrix().getColumns());
					updateMatrixLocations();
				}catch(Exception ex) {
					
				}
				
			}
			
		});
		this.firstColumns= new JTextField();
		this.firstColumns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aaaaaaaaaa");
				try {
					int num = Integer.parseInt(firstColumns.getText());
					updateFirstMatrixPanel(firstMatrixPanel.getMatrix().getRows(),num);
					updateMatrixLocations();
				}catch(Exception ex) {
				}
			}
		});
		this.firstColumns.setSize(new Dimension(60,20));
		this.secondRows= new JTextField();
		this.secondRows.setSize(new Dimension(60,20));
		this.secondRows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aaaaaaaaaa");
				try {
					int num = Integer.parseInt(secondRows.getText());
					updateSecondMatrixPanel(num,secondMatrixPanel.getMatrix().getColumns());
					updateMatrixLocations();
				}catch(Exception ex) {
				}
			}
		});
		
		this.secondColumns= new JTextField();
		this.secondColumns.setSize(new Dimension(60,20));
		this.secondColumns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aaaaaaaaaa");
				try {
					int num = Integer.parseInt(secondColumns.getText());
					updateSecondMatrixPanel(secondMatrixPanel.getMatrix().getRows(),num);
					updateMatrixLocations();
				}catch(Exception ex) {
				}
			}
		});
		
		this.multiplyButton = new JButton("MULTIPLY");
		this.multiplyButton.setBackground(Color.CYAN);
		this.multiplyButton.setSize(new Dimension(100,100));
		this.multiplyButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Matrix m = MatrixMultiplier.multiply(firstMatrixPanel.getMatrix(), secondMatrixPanel.getMatrix());
					updateResultingMatrixPanel(m);
					updateMatrixLocations();
				}catch(MatrixException ex) {
					JOptionPane.showMessageDialog(secondMatrixPanel, "sizes of matrixes are incompatible for multiplication");
				}
			}
			
		});
		
		this.updateMatrixLocations();
		
		
		this.setVisible(true);
		this.setBackground(new Color(0xcc7722));
	}
	public void updateMatrixLocations() {
		this.remove(firstColumns);
		this.remove(firstRows);
		this.remove(secondColumns);
		this.remove(secondRows);
		this.remove(this.multiplyButton);
		this.remove(this.firstMatrixPanel);
		this.remove(this.secondMatrixPanel);
		this.remove(this.resultingMatrixPanel);
		
		
		this.firstMatrixPanel.setLocation(10,100);
		this.secondMatrixPanel.setLocation(this.firstMatrixPanel.getLocation().x+ this.firstMatrixPanel.getWidth()+30,this.firstMatrixPanel.getY());
		this.resultingMatrixPanel.setLocation(new Point(this.secondMatrixPanel.getLocation().x+ this.secondMatrixPanel.getWidth()+150,this.firstMatrixPanel.getY()));
		this.firstRows.setLocation(this.firstMatrixPanel.getLocation().x,this.firstMatrixPanel.getY()-40);
		this.firstRows.setBackground(Color.GREEN);
		this.firstColumns.setLocation(this.firstMatrixPanel.getLocation().x,this.firstMatrixPanel.getY()-20);
		this.firstColumns.setBackground(Color.GREEN);
		this.secondRows.setLocation(this.secondMatrixPanel.getLocation().x,this.secondMatrixPanel.getY()-40);
		this.secondRows.setBackground(Color.GREEN);
		this.secondColumns.setLocation(this.secondMatrixPanel.getLocation().x,this.secondMatrixPanel.getY()-20);
		this.secondColumns.setBackground(Color.GREEN);
		this.multiplyButton.setLocation(new Point(this.secondMatrixPanel.getLocation().x+ this.secondMatrixPanel.getWidth()+30,this.firstMatrixPanel.getY()+30));
		
		
		this.add(firstColumns);
		this.add(firstRows);
		this.add(secondColumns);
		this.add(secondRows);
		this.add(this.multiplyButton);
		this.add(this.firstMatrixPanel);
		this.add(this.secondMatrixPanel);
		this.add(this.resultingMatrixPanel);
		
		
	}
	public void updateFirstMatrixPanel(int rows,int columns) {
		this.remove(this.firstMatrixPanel);
		this.firstMatrixPanel = new MatrixPanel(rows,columns);
		this.updateMatrixLocations();
		this.repaint();
	}
	public void updateSecondMatrixPanel(int rows,int columns) {
		this.remove(this.secondMatrixPanel);
		this.secondMatrixPanel = new MatrixPanel(rows,columns);
		this.updateMatrixLocations();
		this.repaint();
	}
	public void updateResultingMatrixPanel(Matrix matrix) {
		this.remove(this.resultingMatrixPanel);
		this.resultingMatrixPanel = new MatrixPanel(matrix);
		this.updateMatrixLocations();
		this.repaint();
	}
	
}
