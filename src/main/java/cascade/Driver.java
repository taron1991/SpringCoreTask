package cascade;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@AllArgsConstructor
@Data
@Table(name = "drivers")
@EqualsAndHashCode
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String surname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", fetch = FetchType.LAZY)
    private List<Car> cars;
}
