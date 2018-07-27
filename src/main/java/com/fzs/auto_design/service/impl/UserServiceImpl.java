package com.fzs.auto_design.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzs.auto_design.entity.User;
import com.fzs.auto_design.mapper.UserMapper;
import com.fzs.auto_design.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean insert(User user) {
        return super.insert(user);
    }
}
