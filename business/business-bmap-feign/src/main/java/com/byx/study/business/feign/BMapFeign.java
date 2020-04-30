package com.byx.study.business.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "business-bmap",path = "bmap")
public interface BMapFeign {
}
