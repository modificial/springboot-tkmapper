package com.modificial.dao;

import com.modificial.entity.User;
import com.modificial.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description 用户操作
 */
@Mapper
public interface UserDao extends MyMapper<User> {
}
