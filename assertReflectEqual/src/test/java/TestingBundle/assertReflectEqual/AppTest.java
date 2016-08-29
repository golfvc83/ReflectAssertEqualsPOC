package TestingBundle.assertReflectEqual;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import TestingBundle.assertReflectEqual.App;
import TestingBundle.assertReflectEqual.App.LabMouse;
import static org.unitils.reflectionassert.ReflectionAssert.*;

import java.lang.reflect.InvocationTargetException;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    public void testApp() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
    	LabMouse mouse1 = new App().new LabMouse();
		LabMouse mouse2 = new App().new LabMouse();
		ReflectiveRandomSetter.settingRandomFieldValue(mouse1);
		mouse2.setAge(mouse1.getAge());
		mouse2.setCode(mouse1.getCode());
		mouse2.setName(mouse1.getName());
		mouse2.setDob(mouse1.getDob());
		mouse2.setPrice(mouse1.getPrice());
		assertReflectionEquals(mouse1, mouse2);
    //assertReflectionEquals("messaage test",mouse1,mouse2,ReflectionComparatorMode.IGNORE_DEFAULTS);
    assertReflectionEquals("test",mouse1, mouse2);
    }
}
