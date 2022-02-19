package stream.tasks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для задач по Stream API
 * @author Nesterenko Nikita
 * @since 1.0
 */
public class TasksOfStreamApi {

    /**
     * Метод вычисляет общий средний балл по всем студентам и их предметам и округляет данный бал до ближайшего целого
     * @param students - студенты
     * @return средний балл по всем предметам у студентов
     */
    public long getAverageScore(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .stream()
                .mapToLong(Math::round)
                .findFirst()
                .orElse(-1);
    }

    /**
     * Метод находит имя лучшего ученика. Лучший ученик тот, у кого средний балл по его предметам наибольший.
     * @param students студенты
     * @return имя лучшего ученика
     */
    public String getBestStudent(List<Student> students) {
        return students.stream()
                .flatMap(student ->
                        student.getSubjects()
                                .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .stream()
                                .mapToObj(tuple -> new Tuple(student.getName(), tuple)))
                .max(Comparator.comparing(Tuple::getScore))
                .map(Tuple::getName)
                .orElse("N/A");
    }

    /**
     * Вывести уникальное количество предметов
     * @param students студенты
     * @return их предметы
     */
    public List<String> getUniqueSubject(List<Student> students) {
        return students
                .stream()
                .flatMap(student -> student.getSubjects().stream())
                .map(Subject::getName)
                .distinct()
                .collect(Collectors.toList());
    }
}
