package com.fzs.auto_design.service;

import com.baomidou.mybatisplus.service.IService;
import com.fzs.auto_design.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
public interface IUserService extends IService<User> {

    @Override
    boolean insert(User user);
}
