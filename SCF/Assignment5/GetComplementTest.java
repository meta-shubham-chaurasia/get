package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GetComplementTest {

	private int[] fInput2;
	private int[] fExpected;
	
	public GetComplementTest(int[] input2,int[] expected){
		this.fInput2=input2;
		this.fExpected=expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {7,8,9,10},new int[] {1,2,3,4,5,6}}
			});
	}
	@Test
	public void test() {
		intSet set=new intSet(fInput2);
		assertArrayEquals(fExpected,set.GetComplement());
	}


}

