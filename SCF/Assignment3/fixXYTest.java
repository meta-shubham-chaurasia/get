package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class fixXYTest {

	private int fInput[];
	private int fExpected[];
	private int n;
	private int X;
	private int Y;
	
	public fixXYTest(int input[],int expected[],int n,int X,int Y){
		this.fInput=input;
		this.fExpected=expected;
		this.n=n;
		this.X=4;
		this.Y=5;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {5,4,9,4,9,5},new int[] {9,4,5,4,5,9},6,4,5},
			{new int[] {1,4,1,5},new int[] {1,4,5,1},4,4,5},
			{new int[] {1,4,1,5,5,4,1},new int[] {1,4,5,1,1,4,5},7,4,5}
			});
	}
	@Test
	public void test() {
		ArrOperation fixXY=new ArrOperation();
		assertArrayEquals(fExpected,fixXY.YfollowsX(fInput,n,X,Y));
	}

}

