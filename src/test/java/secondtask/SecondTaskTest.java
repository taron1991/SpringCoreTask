package secondtask;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class SecondTaskTest {

    @Test
    public void collect() {
        var secondTask = new SecondTask();
        var text = "aaaabbbbcccdde";
        var expectedSize = 5;
        var expectedCountA = 4;
        var expectedCountC = 3;
        var expectedCountB = 4;
        var expectedCountD = 2;
        var result = secondTask.collect(text);
        Assert.assertEquals(result.size(), expectedSize);
        Assert.assertEquals(result.get('a').intValue(), expectedCountA);
        Assert.assertEquals(result.get('c').intValue(), expectedCountC);
        Assert.assertEquals(result.get('b').intValue(), expectedCountB);
        Assert.assertEquals(result.get('d').intValue(), expectedCountD);
    }

}