package cascade;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@Table(name = "cars")
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = true)
    private Driver driver;
}
