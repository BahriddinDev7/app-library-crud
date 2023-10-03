package uz.pdp.applibrary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Book {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column( nullable = false)
    private String title;

    //@ManyToOne(fetch = FetchType.LAZY)
    private String authorName;

    private int  pages;

    private String publisher;

    @CreationTimestamp
    @Column(insertable = true, updatable = false)
    private LocalDate publishedAt;

    private String description;
}
