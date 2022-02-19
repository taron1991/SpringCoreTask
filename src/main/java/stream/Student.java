package stream;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Student {
    private int age;

    private String name;

    private List<Lesson> lessons;
}
