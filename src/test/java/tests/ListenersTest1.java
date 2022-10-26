package tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//TEST CLASS
//Test classini utility classina baglamak icin @Listeners annotation'i kullanilir
@Listeners(utilities.Listeners.class)
public class ListenersTest1 {

    @Test
    public void test01() {
        System.out.println("Test Case 1 -Pass");
        Assert.assertTrue(true); //pass
    }

    @Test
    public void test02() {
        System.out.println("Test Case 2 -Failed");
        Assert.assertTrue(false); //failed
    }

    @Test
    public void test03() {
        System.out.println("Test Case 3 -Skipped");
        throw new SkipException("Skipped"); //skip
    }
}
