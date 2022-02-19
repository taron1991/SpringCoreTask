package stream.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Класс студента
 */
@Data
@Builder
@AllArgsConstructor
public class Student {
    private String name;

    List<Subject> subjects;
}
