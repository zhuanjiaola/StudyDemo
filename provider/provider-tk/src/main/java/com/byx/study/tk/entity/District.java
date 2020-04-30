package com.byx.study.tk.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "district")
public class District {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`name`")
    private String name;
}