package com.fzs.auto_design.controller;


import com.fzs.auto_design.common.Response;
import com.fzs.auto_design.common.ResponseStatus;
import com.fzs.auto_design.entity.User;
import com.fzs.auto_design.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
@Controller
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

    /**
     * TODO:不直接跳转页面，返回信息，交由前端判断
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Response login(User user, HttpServletRequest request) {
        if (null == user) {
            return new Response(ResponseStatus.ERROR2.getCode(), "未获取到用户信息");
        }
        return userService.login(user, request);
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/front/login";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public Response logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("login");
        return new Response(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg());
    }
}

