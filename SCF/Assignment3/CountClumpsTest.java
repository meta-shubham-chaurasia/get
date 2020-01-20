package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CountClumpsTest{
private int fInput[];
private int fsize;
private int fExpected;

public CountClumpsTest(int input[],int size,int expected){
this.fInput=input;
this.fsize=size;
this.fExpected=expected;
}

@Parameters
public static Collection<Object[]> data(){
return Arrays.asList(new Object[][] {
{new int[] {1,2,2,3,4,4},6,2},
{new int[] {1,1,2,1,1},5,2},
{new int[] {1,1,1,1,1},5,1}
});
}
@Test
public void test() {
ArrOperation numberOfClump=new ArrOperation();
assertEquals(fExpected,numberOfClump.NumberOfClumps(fInput,fsize));
//fail("Not yet implemented");
}

}
