package hibernate;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Cacheable
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic(optional = false) // если false , то notNull, если true, то null
    @Column(name = "name")
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image")
    private byte[] image;

    @Column(name = "sex_type")
    @Enumerated(EnumType.STRING)
    private SexType sexType;

    @Version
    @Column(name = "version")
    private int version;
 }
