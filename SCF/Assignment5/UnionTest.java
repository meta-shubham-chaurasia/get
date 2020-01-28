package hello;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UnionTest {

	private int[] fInput;
	private int[] fInput2;
	private int[] fExpected;
	private int[] fI;
	
	public UnionTest(int[] fI,int[] input1,int[] input2,int[] expected){
		this.fI=fI;
		this.fInput=input1;
		this.fInput2=input2;
		this.fExpected=expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {},new int[] {2,4,6},new int[] {1,3,7,9,12},new int[] {1,2,3,4,6,7,9,12} },
			{new int[] {},new int[] {1,2,3,4},new int[] {2,3,5},new int[] {1,2,3,4,5} }
			});
	}
	@Test
	public void test() {
		intSet set=new intSet(fI);
		assertArrayEquals(fExpected,set.Union(fInput,fInput2));
	}

}
