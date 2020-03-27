package com.example.demo.dao;

import com.example.demo.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author Lyz
 * @since 2020-03-25
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
