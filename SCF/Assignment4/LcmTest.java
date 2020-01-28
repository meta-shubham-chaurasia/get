package hello;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LcmTest{
private int fX;
private int fY;
private int fExpected;

public LcmTest(int input1,int input2,int expected){
this.fX=input1;
this.fY=input2;
this.fExpected=expected;
}

@Parameters
public static Collection<Object[]> data(){
return Arrays.asList(new Object[][] {
{16,4,16},
{15,10,30},
{60,11,660}
});
}
@Test
public void test() {
LcmHcf lcm=new LcmHcf();
assertEquals(fExpected,lcm.Lcm(fX,fY));
//fail("Not yet implemented");
}

}

