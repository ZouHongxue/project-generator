package com.fzs.auto_design.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzs.auto_design.common.Response;
import com.fzs.auto_design.entity.User;
import com.fzs.auto_design.mapper.UserMapper;
import com.fzs.auto_design.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
