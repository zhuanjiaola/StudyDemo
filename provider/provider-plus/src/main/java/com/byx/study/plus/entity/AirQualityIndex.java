package com.byx.study.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "air_quality_index")
public class AirQualityIndex {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "districtid")
    private Integer districtid;

    @TableField(value = "monitortime")
    private Date monitortime;

    @TableField(value = "pm10")
    private Integer pm10;

    @TableField(value = "pm25")
    private Integer pm25;

    @TableField(value = "monitoringstation")
    private String monitoringstation;

    @TableField(value = "lastmodifytime")
    private Date lastmodifytime;
}