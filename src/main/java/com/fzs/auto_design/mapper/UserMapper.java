package com.fzs.auto_design.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.fzs.auto_design.entity.User;
import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
public interface UserMapper extends BaseMapper<User> {

    @Override
//    @Insert("insert into user (name, password, status) value (#{name}, #{password}, #{status})")
    Integer insert(User user);

    User selectOne(Wrapper<User> wrapper);
}
