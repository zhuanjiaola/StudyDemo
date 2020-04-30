package com.byx.study.tk.service.imp;

import com.byx.study.tk.mapper.AirQualityIndexMapper;
import com.byx.study.tk.service.AirQualityIndexService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class AirQualityIndexServiceImpl implements AirQualityIndexService{

    @Resource
    private AirQualityIndexMapper airQualityIndexMapper;


}
