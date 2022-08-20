package com.example.demo;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    public String hi(@RequestBody List<String> param) {
        System.out.println(param);
        return JSONObject.toJSONString(param);
    }

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        try {
            return "sdfsd";
        } catch (Exception e) {
            System.out.println(JSONObject.toJSONString(e));
        }finally {
            System.out.println(123);
            return "heoo";
        }


    }



}
