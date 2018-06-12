package com.modificial.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.modificial.api.anoncation.ApiService;
import com.modificial.api.exception.ServiceException;
import com.modificial.api.response.JsonResult;
import com.modificial.api.response.Page;
import com.modificial.api.service.ApiUserService;
import com.modificial.ato.vo.UserRes;
import com.modificial.dao.UserDao;
import com.modificial.entity.User;
import com.zaxxer.hikari.util.FastList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description
 */
@ApiService
@Slf4j
public class ApiUserServiceImpl implements ApiUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public JsonResult listUser() {
        List<User>userList=userDao.selectAll();
        log.info("开始返回用户信息----->>>"+JSON.toJSONString(userList));
        JsonResult jsonResult=new JsonResult("40000",userList);
        return jsonResult;
    }

    @Override
    public JsonResult updateUserById(User user) throws ServiceException {
        if (user==null||user.getId()==null){
            throw new ServiceException("用户Id为空，更新失败！");
        }
        userDao.updateByPrimaryKey(user);
        log.info("用户信息更新成功");
        JsonResult jsonResult=new JsonResult("40000");
        return jsonResult;
    }

    @Override
    public JsonResult saveUser(User user) throws ServiceException {
        if (user==null){
            throw new ServiceException("用户信息为空，保存失败！");
        }
        JsonResult jsonResult;
       int result= userDao.insert(user);
        if (result>0) {
            log.info("用户信息保存成功");
             jsonResult = new JsonResult("40000");
            return  jsonResult;
        }
        jsonResult=new JsonResult("45000");
        return  jsonResult;
    }

    @Override
    public JsonResult deleteUserById(String userId) throws ServiceException {
       if ((StringUtils.isEmpty(userId))){
           throw new ServiceException("用户Id为空，删除失败！");
       }
       JsonResult jsonResult;
      int result= userDao.deleteByPrimaryKey(userId);
        if (result>0) {
            log.info("用户信息删除成功");
            jsonResult = new JsonResult("40000");
            return  jsonResult;
        }
        jsonResult=new JsonResult("45000");
        return  jsonResult;
    }

    @Override
    public JsonResult pageUser(Integer pageNo, Integer pageSize) {
        if(pageNo==null||pageNo<0){
            pageNo=1;
        }
        if(pageSize==null||pageSize<0){
            pageSize=10;
        }
        PageHelper.startPage(pageNo,pageSize);
        List<User>list=userDao.selectAll();
        PageInfo<User>pageInfo=new PageInfo<>(list);
        Page<UserRes>userResPage=new Page<>();
        List<UserRes>userResList=new FastList<>(UserRes.class);
        pageInfo.getList().forEach(it->{
         UserRes userRes=new UserRes();
            BeanUtils.copyProperties(it,userRes);
            userResList.add(userRes);
        });
        userResPage.setCollection(userResList);
        userResPage.setCount(pageInfo.getTotal());
        log.info("开始返回用户分页用户信息---》》》"+JSON.toJSONString(userResList));
        return  new JsonResult("40000",userResList);
    }
}
