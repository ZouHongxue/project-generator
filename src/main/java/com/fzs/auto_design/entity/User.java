package com.fzs.auto_design.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 邹洪学
 * @since 2018-07-27
 */
@ApiModel(value = "用户", description = "描述用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邹洪学|用户唯一主键|2018-07-27
     */
    @ApiModelProperty(name = "id", notes = "用户唯一ID", example = "100", dataType = "Integer", required = false)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 邹洪学|用户姓名|2018-07-27
     */
    @ApiModelProperty(name = "name", notes = "姓名", example = "张三")
    private String name;

    /**
     * 邹洪学|用户密码|2018-07-27
     */
    @ApiModelProperty(name = "password", notes = "密码", example = "123456")
    private String password;

    /**
     * @0正常 @other 异常|邹洪学|用户状态标识|2018-07-27
     */
    @ApiModelProperty(name = "status", notes = "状态", example = "0", dataType = "Integer")
    private Integer status;

    /**
     * 邹洪学|创建时间|2018-07-27
     */
    @ApiModelProperty(name = "createTime", notes = "创建时间", dataType = "LocalDateTime", example = "2018-07-27 10:33:59")
    private LocalDateTime createTime;

    /**
     * 邹洪学|更新时间|2018-07-27
     */
    @ApiModelProperty(name = "updateTime", notes = "更新时间", dataType = "LocalDateTime", example = "2018-07-27 10:33:59")
    private LocalDateTime updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", name=" + name +
        ", password=" + password +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
