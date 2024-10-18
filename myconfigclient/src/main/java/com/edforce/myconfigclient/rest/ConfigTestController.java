package com.edforce.myconfigclient.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class ConfigTestController {
//
    @Value(("${organization.name:defaultValue}"))
    private String orgName;

    @Value(("${db.url:defaultValue}"))
    private String dbUrl;


    @Value(("${prop1:someDefValue}"))
    private String newProp1;

    @Value(("${prop2:someDefValue}"))
    private String newProp2;


    @GetMapping("/getData")
    public Map<String,String> getCommonPRoperties(){

        Map<String,String> map = new HashMap<>();
//
        map.put("orgName", orgName);
        map.put("dbUrl",dbUrl);
        map.put("prop1",newProp1);
        map.put("prop2",newProp2);

        return map;
    }

}
