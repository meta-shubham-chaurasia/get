package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitArrayTest{
private int fInput[];
private int fExpected;

public SplitArrayTest(int input[],int expected){
this.fInput=input;
this.fExpected=expected;
}

@Parameters
public static Collection<Object[]> data(){
return Arrays.asList(new Object[][] {
{new int[] {1,1,1,2,1},3},
{new int[] {2,1,1,2,1},-1},
{new int[] {10,10},1}
});
}
@Test
public void test() {
ArrOperation splitIndex=new ArrOperation();
assertEquals(fExpected,splitIndex.SplitIndex(fInput));
//fail("Not yet implemented");
}
}

