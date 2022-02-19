package stream.tasks;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для задач по Stream API
 * @author Nesterenko Nikita
 * @since 1.0
 */
public class TasksOfStreamApi {

    private static final String EMPTY = "";
    private static final long INCORRECT_RESULT = -1;

    /**
     * Метод вычисляет общий средний балл по всем студентам и их предметам и округляет данный бал до ближайшего целого
     * @param students - студенты
     * @return средний балл по всем предметам у студентов
     */
    public long getAverageScore(List<Student> students) {
        return INCORRECT_RESULT;
    }

    /**
     * Метод находит имя лучшего ученика. Лучший ученик тот, у кого средний балл по его предметам наибольший.
     * @param students студенты
     * @return имя лучшего ученика
     */
    public String getBestStudent(List<Student> students) {
        return EMPTY;
    }

    /**
     * Вывести уникальное количество предметов
     * @param students студенты
     * @return их предметы
     */
    public List<String> getUniqueSubject(List<Student> students) {
        return Collections.emptyList();
    }
}
