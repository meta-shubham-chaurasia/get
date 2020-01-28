package hello;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinearSearchTest{
private int farr[];
private int fvalue;
private int fi;
private int fExpected;

public LinearSearchTest(int arr[],int value,int i,int expected){
this.farr=arr;
this.fvalue=value;
this.fi=i;
this.fExpected=expected;
}

@Parameters
public static Collection<Object[]> data(){
return Arrays.asList(new Object[][] {
{new int[]{1,5,7,3,2},1,0,0},
{new int[]{1,5,7,3,2},5,0,1},
{new int[]{1,5,7,3,2},2,0,4}
});
}
@Test
public void test() {
Search linearSearch=new Search();
assertEquals(fExpected,linearSearch.LinearSearch(farr,fvalue,fi));
//fail("Not yet implemented");
}

}
