package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IsSubsetTest {

	private int[] fInput;
	private int[] fInput2;
	private boolean fExpected;
	private int[] fI;
	
	public IsSubsetTest(int[] fI,int[] input1,int[] input2,boolean expected){
		this.fI=fI;
		this.fInput=input1;
		this.fInput2=input2;
		this.fExpected=expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {},new int[] {1,2,3,4,5},new int[] {3,4},true },
			{new int[] {},new int[] {1,2,3,4,5},new int[] {3,7},false }
			});
	}
	@Test
	public void test() {
		intSet set=new intSet(fI);
		assertEquals(fExpected,set.IsSubset(fInput,fInput2));
	}


}