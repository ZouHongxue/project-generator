package com.fzs.auto_design.service;


import com.fzs.auto_design.common.Response;
import com.fzs.auto_design.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
public interface IUserService {

    /**
     * 新建用户
     * @param user
     * @return
     */
    Response insert(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Response update(User user);
}
