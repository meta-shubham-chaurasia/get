package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HcfTest{
private int fX;
private int fY;
private int fExpected;

public HcfTest(int input1,int input2,int expected){
this.fX=input1;
this.fY=input2;
this.fExpected=expected;
}

@Parameters
public static Collection<Object[]> data(){
return Arrays.asList(new Object[][] {
{16,4,4},
{15,10,5},
{60,11,1}
});
}
@Test
public void test() {
LcmHcf hcf=new LcmHcf();
assertEquals(fExpected,hcf.Hcf(fX,fY));
//fail("Not yet implemented");
}

}
