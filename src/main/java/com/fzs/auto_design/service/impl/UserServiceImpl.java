package com.fzs.auto_design.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzs.auto_design.common.Constant;
import com.fzs.auto_design.common.Response;
import com.fzs.auto_design.common.ResponseStatus;
import com.fzs.auto_design.entity.User;
import com.fzs.auto_design.mapper.UserMapper;
import com.fzs.auto_design.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response insert(User user) {
        userMapper.insert(user);
        return Response.successInstance(user);
    }

    @Override
    public Response update(User user) {
        userMapper.update(user);
        return Response.successInstance(user);
    }

    @Override
    public Response login(User user, HttpServletRequest request) {
        List<User> users = userMapper.getUserByName(user);
        if(users.size() == Constant.ZERO) {
            return new Response(ResponseStatus.ERROR3.getCode(), "用户名错误");
        }
        if (users.size() > Constant.ONE) {
            return new Response(ResponseStatus.ERROR3.getCode(), "数据异常");
        }
        User user2 = users.get(0);
        if (user.getPassword().equals(user2.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("login", "true");
            session.setAttribute("user", user2);
            return new Response(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), user2);
        }
        return new Response(ResponseStatus.ERROR3.getCode(), "密码错误");
    }
}
