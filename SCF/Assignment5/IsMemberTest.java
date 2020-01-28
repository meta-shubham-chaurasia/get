package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IsMemberTest {

	private int fInput[];
	private int fInput2;
	private boolean fExpected;
	
	public IsMemberTest(int input[],int input2,boolean expected){
		this.fInput=input;
		this.fInput2=input2;
		this.fExpected=expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {},4,true}
			});
	}
	@Test
	public void test() {
		intSet set=new intSet(fInput);
		assertEquals(fExpected,set.IsMember(fInput2));
	}

}