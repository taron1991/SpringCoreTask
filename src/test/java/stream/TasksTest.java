package stream;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TasksTest {

    Map<String, List<Lesson>> rsl;

    @BeforeMethod
    public List<Student> setUp() {
        Student student1 = Student.builder()
                .name("Test1")
                .age(5)
                .lessons(
                        List.of(
                                new Lesson("Test1", 2),
                                new Lesson("Test2", 1)
                        )
                )
                .build();

        Student student2 = Student.builder()
                .name("Test2")
                .age(4)
                .lessons(
                        List.of(
                                new Lesson("Test1", 3),
                                new Lesson("Test2", 4)
                        )
                )
                .build();
        return List.of(student1, student2);
    }

    @Test
    public void testStreamApi() {

        rsl = Sheduled.collectTable(setUp());

        Map<String, List<Lesson>> expected = new HashMap<>();
        expected.put("Test1", List.of(
                new Lesson("Test2", 1),
                new Lesson("Test1", 2)));
        expected.put("Test2", List.of(
                new Lesson("Test1", 3),
                new Lesson("Test2", 4)));

        Assert.assertEquals(rsl, expected);
    }

    @AfterMethod
    public void clear() {
        rsl.clear();
        System.out.println(rsl);
    }
}