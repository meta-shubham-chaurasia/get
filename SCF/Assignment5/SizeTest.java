package hello;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SizeTest {

	private int fInput[];
	private int fExpected;
	
	public SizeTest(int input[],int expected){
		this.fInput=input;
		this.fExpected=expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {1,2,3,4,5,6},6}
			});
	}
	@Test
	public void test() {
		intSet set=new intSet(fInput);
		assertEquals(fExpected,set.Size());
	}


}