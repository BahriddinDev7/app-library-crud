package uz.pdp.applibrary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private int age;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Author", fetch = FetchType.LAZY)
    private String bookName;
}
