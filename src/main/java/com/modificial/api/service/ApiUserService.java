package com.modificial.api.service;

import com.modificial.api.exception.ServiceException;
import com.modificial.api.response.JsonResult;
import com.modificial.entity.User;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description 用户操作
 */
public interface ApiUserService {
    /**
     * 查询所有用户信息
     * @return
     */
    JsonResult listUser();

    /**
     * 用户信息
     * @param user 用户信息
     * @return 状态码
     */
    JsonResult updateUserById(User user) throws ServiceException;

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return
     */
    JsonResult saveUser(User user) throws ServiceException;

    /**
     * 根据用户id删除用户
     * @param userId 用户id
     * @return 状态码
     */
    JsonResult deleteUserById(String userId) throws ServiceException;

    /**
     * 分页查询用户信息
     * @param pageNo 第几页
     * @param pageSize 每页显示几条数据
     * @return 状态码 用户信息列表
     */
    JsonResult pageUser(Integer pageNo,Integer pageSize);
}
