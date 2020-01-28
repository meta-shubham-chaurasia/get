package hello;

import java.util.ArrayList;

public class Matrix {
	
	private ArrayList<Position> positions;
	private final int rows ;
	private final int cols ;
	
	public ArrayList<Position> getMatrix() {
		return positions;
	}

	public int getRows() {
		return rows;
	}


	public int getCols() {
		return cols;
	}


	Matrix(int[][] matrix) {
		this.rows = matrix.length;
		if(matrix.length>0)
			this.cols = matrix[0].length;
		else
			throw new AssertionError();
		
		this.positions = new ArrayList<Position>();
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length ;j++) {
				if(matrix[i][j] != 0) {
					positions.add(new Position(i,j,matrix[i][j]));
				}
			}
	}
	
	
	/**
	 * 
	 * @return Return transpose of Matrix
	 * 
	 * COMPLEXITY - O(n) where n => Number of nonzero Elements of Matrix
	 */
	public int[][] getTranspose() {
		//ArrayList<Position> newMatrix = new ArrayList<Position>();
		int [][] transpose = new int[this.cols][this.rows];
		for(Position position:this.positions) {
			//newMatrix.add(new Position(position.getCol(),position.getRow(),position.getValue()));
			transpose[position.getCol()][position.getRow()] = position.getValue();
		}
		//Matrix transpose = new Matrix(newMatrix,this.cols,this.rows);
		return transpose;
	}
	
	/**
	 * 
	 * @return If the Matrix objects holds Symmetrical Matrix return true otherwise false
	 * 
	 * COMPLEXITY - O(n^2) where n => Number of nonzero Elements of Matrix
	 */
	public boolean isSymmetrical() {
		int count = 0;
		int diagonal = 0;
		if(rows != cols) 
			return false;
		for(Position position1 : this.positions) {
			if(position1.getRow() == position1.getCol()) {
				//count += 1;
				diagonal += 1;
			} else {
				for(int j = this.positions.indexOf(position1) + 1 ;j<this.positions.size();j++) {
					Position position2 = this.positions.get(j);
					if(!position1.equals(position2) &&
							position1.getRow() == position2.getCol() &&
							position1.getCol() == position2.getRow() &&
							position1.getValue() == position2.getValue())
						count += 1;
				}
			}
		}
		
		if(2*count + diagonal == this.positions.size())
			return true;
		return false;
	}
	
	
	/**
	 * 
	 * @param firstMatrix Matrix object Represent Matrix 1
	 * @param secondMatrix Matrix object Represent Matrix 2
	 * @return addition of Both matrix and return a matrix of 2D array in result
	 * 
	 * COMPLEXITY - O(n^2) where n => Number of nonzero Elements of Matrix
	 */
	public static int[][] addTwoMatrix(Matrix firstMatrix , Matrix secondMatrix ) {
		if(firstMatrix.getRows() != secondMatrix.getRows() || firstMatrix.getCols() != secondMatrix.getCols()) 
			throw new AssertionError();
		
		//ArrayList<Position> newMatrix = new ArrayList<Position>();
		int[][] result = new int [firstMatrix.getRows()][firstMatrix.getCols()];
		boolean flag;
		boolean [] flagForM2 = new boolean[secondMatrix.getMatrix().size()];

		for(Position position1 :firstMatrix.getMatrix()) {
			flag = true;
			for(Position position2 : secondMatrix.getMatrix()) {
				if(position1.getRow() == position2.getRow() &&
						position1.getCol() == position2.getCol()) {
					
					result [position1.getRow()][position1.getCol()] = position1.getValue() + position2.getValue();
					flagForM2[secondMatrix.getMatrix().indexOf(position2)] = true;
					//newMatrix.add(new Position(position1.getRow(),position1.getCol() , 
							//position1.getValue() + position2.getValue()));
					flag = false;
					break;
				}
			}
			if(flag) {
				//newMatrix.add(new Position(position1.getRow(),position1.getCol() , position1.getValue()));
				result [position1.getRow()][position1.getCol()] = position1.getValue();
			}	
		}
		
		for (int i=0;i<secondMatrix.getMatrix().size();i++) {
			if(!flagForM2[i]) {
				Position position2 = secondMatrix.getMatrix().get(i);
				result[position2.getRow()][position2.getCol()] = position2.getValue();
			}
				
			
			//if(!newMatrix.contains(position2)) {
				//newMatrix.add(position2);
			//}
		}
		//return new Matrix(newMatrix ,  firstMatrix.getRows(),firstMatrix.getCols());
		return result;
	}
	
	
	/**
	 * 
	 * @param firstMatrix Matrix object Represents First Matrix
	 * @param secondMatrix Matrix object Represents Second Matrix
	 * @return Multiplication of Both Matrix and return 2D Array in result
	 * 
	 * COMPLEXITY - O(n^2) where n => Number of nonzero Elements of Matrix
	 */
	public static int[][]  multiplyTwoMatrix(Matrix firstMatrix, Matrix secondMatrix) {
		if(firstMatrix.getCols() != secondMatrix.getRows()) {
			throw new AssertionError();
		} 
		
		int[][] result = new int[firstMatrix.getRows()][secondMatrix.getCols()];
		
		for (Position position1 : firstMatrix.getMatrix()) {
			for (Position position2 : secondMatrix.getMatrix()) {
				if(position1.getCol() == position2.getRow()) {
					result[position1.getRow()][position2.getCol()] += position1.getValue() * position2.getValue();
				}
			}
		}
		return result;
	}
	
	
	//To Display Positions 
	public void displayPoints() {
		for(Position p : this.positions) {
			System.out.println(p.getRow() + ","+p.getCol()+" --> "+p.getValue());
		}
	}
	
	//TO display a Matrix with given string s
	public static void display(String s , int[][] matrix ) {
		System.out.println("\n"+s);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" , ");
			}
			System.out.println();
		}
	}
	
	
	
}