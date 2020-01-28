package hello;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the sparse matrix class.
 */
public class TestMatrix {
	
	/**
	 * Test for transpose of matrix.
	 */
	@Test
	public void TestSparseMtrix_transpose(){
		int[][] arr = 
				{{1,2,3},
				{8,7,4},
				{1,5,9}};
		Matrix s1 = new Matrix(arr);
		int[][] b = s1.getTranspose();
		boolean check = true;
		

		for(int i=0;i<arr.length;i++){
			for(int j=0;j<b[0].length;j++){
				if(arr[i][j]!=b[i][j])
					check = false;
			}
		}

		assertEquals(false,check);
	}

	/**
	 * Test for symmetry of matrix.
	 */
	@Test
	public void TestSparseMtrix_CheckSymmetry(){
		int[][] arr = 
				{{1,0,1},
				 {0,5,0},
				 {1,0,6}};
		Matrix s1 = new Matrix(arr);
		boolean check = s1.isSymmetrical();
		assertEquals(true,check);
	}

	/**
	 * Test for addition of matrix.
	 */
	@Test
	public void TestSparseMtrix_addMatrix(){
		int[][] arr = 
				{{1,2,3},
				 {4,5,6},
				 {0,1,0}};
		Matrix s1 = new Matrix(arr);

		int[][] brr = 
				{{5,6,7},
				 {1,6,1},
				 {3,4,0}};
		Matrix s2 = new Matrix(brr);

		int[][] crr = 
				{{6,8,10},
				 {5,11,7},
				 {3,5,0}};
		int[][] b = Matrix.addTwoMatrix(s1, s2);
		
		assertMatrixEquals(crr,b);

	}

	/**
	 * Test for multiplication of matrix.
	 */
	@Test
	public void TestSparseMtrix_multiplyMatrix(){
		int[][] arr = 
				{{1,2,3},
				 {4,5,6,},
				 {7,8,9}};
		Matrix s1 = new Matrix(arr);

		int[][] brr = 
				{{1,2,3},
				 {4,5,6},
				 {7,8,9}};
		Matrix s2 = new Matrix(brr);

		int[][] crr = 
				{{30,36,42},
				 {66,81,96},
				 {102,126,150}};
		int[][] b = Matrix.multiplyTwoMatrix(s1, s2);
		assertMatrixEquals(crr,b);
	}
	
	void assertMatrixEquals(int[][] m1,int[][] m2) {
		assertEquals(m1.length,m2.length);
		assertEquals(m1[0].length,m2[0].length);
		for(int i=0;i<m1.length;i++) {
			assertArrayEquals(m1[i],m2[i]);
		}
	}
}