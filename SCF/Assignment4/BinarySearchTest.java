package hello;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinarySearchTest{
private int farr[];
private int fvalue;
private int fi;
private int flen;
private int fExpected;

public BinarySearchTest(int arr[],int i,int len,int value,int expected){
this.farr=arr;
this.fvalue=value;
this.fi=i;
this.flen=len;
this.fExpected=expected;
}

@Parameters
public static Collection<Object[]> data(){
return Arrays.asList(new Object[][] {
{new int[]{1,2,3,5,7},0,4,1,0},
{new int[]{1,2,3,5,7},0,4,5,3},
{new int[]{1,2,3,5,7},0,4,7,4},
{new int[]{45,48,53,57,71},2,3,57,5}
});
}
@Test
public void test() {
Search binarySearch=new Search();
assertEquals(fExpected,binarySearch.BinarySearch(farr,fi,flen,fvalue));
//fail("Not yet implemented");
}

}
