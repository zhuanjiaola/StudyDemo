package com.byx.study.tk.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "air_quality_index")
public class AirQualityIndex {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "districtid")
    private Integer districtid;

    @Column(name = "monitortime")
    private Date monitortime;

    @Column(name = "pm10")
    private Integer pm10;

    @Column(name = "pm25")
    private Integer pm25;

    @Column(name = "monitoringstation")
    private String monitoringstation;

    @Column(name = "lastmodifytime")
    private Date lastmodifytime;
}