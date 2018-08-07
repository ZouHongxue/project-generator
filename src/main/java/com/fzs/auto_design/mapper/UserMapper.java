package com.fzs.auto_design.mapper;

import com.fzs.auto_design.entity.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
public interface UserMapper {

    void insert(User user);

    void update(User user);
}
