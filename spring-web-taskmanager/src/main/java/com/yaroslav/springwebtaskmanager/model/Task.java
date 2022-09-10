package com.yaroslav.springwebtaskmanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`task`")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`header`")
    private String header;

    @Column(name = "`description`")
    private String description;

    @Column(name = "`creation_date`")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name = "`deadline`")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadLine;


}
