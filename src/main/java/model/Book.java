package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "PUBLISH_DATE")
    private Date publishDate;

    @NotNull
    @Column(name = "PAGE_COUNT")
    private Integer pageCount;

}
