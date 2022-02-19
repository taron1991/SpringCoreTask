package stream;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Lesson {
    private String name;

    private int priority;
}
