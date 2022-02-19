package stream.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


/**
 * Класс предмета
 */
@Data
@AllArgsConstructor
@Builder
public class Subject {
    private String name;

    private int score;
}
