package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Book {

    private UUID id;
    private Author author;
    private String name;
    private Date publishDate;
    private Integer pageCount;

}
