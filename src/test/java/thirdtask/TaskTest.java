package thirdtask;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaskTest {

    @Test
    public void testCollectFirst() {
        var task = new Task();
        var param = "205,212,503,226,200,101";
        var result = task.collect(param);

        assertEquals(result.size(), 3);
    }

    @Test
    public void testCollectSecond() {
        var task = new Task();
        var param = "205,212,226";
        var result = task.collect(param);

        assertEquals(result.size(), 2);
    }

    @Test
    public void testCollectThird() {
        var task = new Task();
        var param = "501,205";
        var result = task.collect(param);

        assertEquals(result.size(), 1);
    }

    @Test
    public void testCollectFourth() {
        var task = new Task();
        var param = "";
        var result = task.collect(param);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCollectFifth() {
        var task = new Task();
        var result = task.collect(null);

        assertTrue(result.isEmpty());
    }

}