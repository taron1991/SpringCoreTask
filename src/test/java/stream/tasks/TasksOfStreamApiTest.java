package stream.tasks;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TasksOfStreamApiTest {

    private TasksOfStreamApi tasks;

    @BeforeTest
    public List<Student> init() {
        tasks = new TasksOfStreamApi();
        return List.of(
                Student.builder()
                        .name("Никита")
                        .subjects(List.of(
                                new Subject("Математика", 5),
                                new Subject("Физика", 4)
                        ))
                        .build(),

                Student.builder()
                        .name("Александр")
                        .subjects(List.of(
                                new Subject("Математика", 3),
                                new Subject("Русский язык", 4),
                                new Subject("Физика", 2)
                        ))
                        .build(),

                Student.builder()
                        .name("Илья")
                        .subjects(List.of(
                                new Subject("Философия", 3),
                                new Subject("Русский язык", 5),
                                new Subject("Психология", 3)
                        ))
                        .build()

        );
    }

    @Test
    public void testAverageScore() {
        List<Student> students = init();

        long result = tasks.getAverageScore(students);

        // 5 + 4 + 3 + 4 + 2 + 3 + 5 + 3 = 29 sum / 8 size = 3.625 -> around 4
        final long expected = 4L;

        Assert.assertEquals(result, expected);

    }

    @Test
    public void bestStudent() {
        /*
        Средний балл Никиты 5 + 4 = 9 score / 2 size = 4.5
        Средний балл Александра 3 + 4 + 2 = 9 score / 3 size = 3
        Средний балл Ильи 3 + 5 + 3 = 11 score / 3 size =  3.66

        Итог: Никита лучший ученик
         */

        List<Student> students = init();

        String result = tasks.getBestStudent(students);

        final String expected = "Никита";

        Assert.assertEquals(result, expected);
    }

    @Test
    public void getUniqueSubject() {
        List<Student> students = init();

        List<String> expected = List.of(
                "Математика",
                "Физика",
                "Русский язык",
                "Философия",
                "Психология"
        );

        List<String> result = tasks.getUniqueSubject(students);

        Assert.assertEquals(result, expected);
    }
}