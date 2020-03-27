package com.example.demo.service.impl;

import com.example.demo.model.SysUser;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author Lyz
 * @since 2020-03-25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
