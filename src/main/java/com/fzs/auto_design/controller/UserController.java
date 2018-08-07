package com.fzs.auto_design.controller;


import com.fzs.auto_design.common.Response;
import com.fzs.auto_design.entity.User;
import com.fzs.auto_design.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "用户请求API", description = "用户请求API")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiImplicitParam(name = "user", value = "用户信息实体", required = true, paramType = "body", dataType = "User")
    @ApiOperation(value = "创建用户", notes = "使用user对象添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response addUser(User user){
        return userService.insert(user);
    }

    @ApiImplicitParam(name = "user", value = "用户信息实体", required = true, paramType = "body", dataType = "User")
    @ApiOperation(value = "更新", notes = "使用user对象更新用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Response updateUser(User user) {
        return userService.update(user);
    }

}

