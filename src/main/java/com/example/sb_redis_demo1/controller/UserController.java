package com.example.sb_redis_demo1.controller;

import com.example.sb_redis_demo1.model.User;
import com.example.sb_redis_demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById(@RequestBody Map<String,Object> mp){
        int id= (int) mp.get("id");
        User user = userService.findUserById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("name", user.getName());
        return result;
    }
}
