package com.fzs.auto_design.controller;


import com.fzs.auto_design.entity.User;
import com.fzs.auto_design.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/add")
    public String addUser(User user){
        if (userService.insert(user)){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

}

