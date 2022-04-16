package taskforspring;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "index")
    private long id;

    @Column(name = "name")
    private String name;

    public User(String name) {
        this.name = name;
    }
}
