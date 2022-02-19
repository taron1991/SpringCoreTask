package stream.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Tuple {
    private String name;

    private double score;
}
