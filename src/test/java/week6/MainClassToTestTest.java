package week6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import week6.homeworks.MainClassToTest;


@RunWith(MockitoJUnitRunner.class)
public class MainClassToTestTest {

    @InjectMocks
    private MainClassToTest mainClassToTestUnderTest;

    @Test
    public void testReverseString() {
        Assert.assertEquals("xela", mainClassToTestUnderTest.reverseString("alex"));
        Assert.assertEquals("aniri", mainClassToTestUnderTest.reverseString("irina"));
        Assert.assertEquals("ala ala", mainClassToTestUnderTest.reverseString("ala ala"));
        
    }

    @Test
    public void testCheckIfPalindrome() {
        Assert.assertEquals(false, mainClassToTestUnderTest.checkIfPalindrome("alex"));
        Assert.assertEquals(false, mainClassToTestUnderTest.checkIfPalindrome("irina"));
        Assert.assertEquals(true, mainClassToTestUnderTest.checkIfPalindrome("ala ala"));


    }

    @Test
    public void testCountOccurenceOfChar() {
        Assert.assertEquals(3, mainClassToTestUnderTest.countOccurenceOfChar('a', "alaba"));
        Assert.assertEquals(4, mainClassToTestUnderTest.countOccurenceOfChar('e', "revedere"));
        Assert.assertEquals(1, mainClassToTestUnderTest.countOccurenceOfChar('x', "alex"));
    }

    @Test
    public void testCheckIfAllCharsAreDigits() {
        Assert.assertEquals(false, mainClassToTestUnderTest.checkIfAllCharsAreDigits("a54356"));
        Assert.assertEquals(true, mainClassToTestUnderTest.checkIfAllCharsAreDigits("7043554"));
        Assert.assertEquals(false, mainClassToTestUnderTest.checkIfAllCharsAreDigits("alex7134"));

    }

    @Test
    public void testConvertStringToInt() {
        Assert.assertEquals(7543, mainClassToTestUnderTest.convertStringToInt("7543"));
        Assert.assertEquals(32, mainClassToTestUnderTest.convertStringToInt("32"));
        Assert.assertEquals(18756, mainClassToTestUnderTest.convertStringToInt("18756"));


    }

    @Test
    public void testRemoveCharacterFromString() {
        Assert.assertEquals("ale", mainClassToTestUnderTest.removeCharacterFromString('x',"alex"));
        Assert.assertEquals("iria", mainClassToTestUnderTest.removeCharacterFromString('n',"irina"));
        Assert.assertEquals("infomala", mainClassToTestUnderTest.removeCharacterFromString('r',"informala"));

    }

    @Test
    public void testCheckIfRotation() {
       Assert.assertEquals(true, mainClassToTestUnderTest.checkIfRotation("alex", "exal"));
       Assert.assertEquals(false, mainClassToTestUnderTest.checkIfRotation("irina", "exal"));
       Assert.assertEquals(true, mainClassToTestUnderTest.checkIfRotation("informala", "formalain"));
    }


}
