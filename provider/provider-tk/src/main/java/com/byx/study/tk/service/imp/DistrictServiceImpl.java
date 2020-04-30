package com.byx.study.tk.service.imp;

import javax.annotation.Resource;
import com.byx.study.tk.mapper.DistrictMapper;
import com.byx.study.tk.service.DistrictService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DistrictServiceImpl implements DistrictService{

    @Resource
    private DistrictMapper districtMapper;

}
