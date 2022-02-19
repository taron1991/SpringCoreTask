package stream;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class Sheduled {

    public Map<String, List<Lesson>> collectTable(List<Student> studentsList) {

        return studentsList
                .stream()
                .collect(Collectors.toMap(
                                Student::getName, student -> student.getLessons()
                                        .stream()
                                        .sorted(Comparator.comparing(Lesson::getPriority))
                                        .collect(Collectors.toList()))
                        );
    }

}
