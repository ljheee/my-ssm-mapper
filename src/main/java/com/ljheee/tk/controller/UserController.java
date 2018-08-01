package com.ljheee.tk.controller;

import com.ljheee.tk.mapper.UserInfoMapper;
import com.ljheee.tk.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lijianhua04 on 2018/8/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    UserInfoMapper userMapper;


    @GetMapping("/list")
    public List<UserInfo> getUserMapper() {
        return userMapper.selectAll();
    }



    @GetMapping("/find")
    public List<UserInfo> find(){
        Example userExample = new Example(UserInfo.class);
        userExample.createCriteria().andEqualTo("id","1");
        return userMapper.selectByExample(userExample);
    }
}
