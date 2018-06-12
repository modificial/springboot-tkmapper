package com.modificial.api.controller;

/**
 * @author modificial
 * @date 2018/5/19
 * @company codingApi
 * @description
 */

import com.modificial.api.exception.ServiceException;
import com.modificial.api.response.JsonResult;
import com.modificial.api.service.ApiUserService;
import com.modificial.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description 用户管理
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private ApiUserService apiUserService;

    @ApiOperation(value = "查询所有用户信息")
    @GetMapping("/listUser")
    public JsonResult listUser() {
        return apiUserService.listUser();
    }

    @ApiOperation(value = "根据用户id更新用户信息")
    @PostMapping("/updateUserById")
    public JsonResult updateUserById(@RequestBody User user) throws ServiceException {

        return apiUserService.updateUserById(user);
    }

    @ApiOperation(value = "保存用户信息")
    @PostMapping("/saveUser")
    public JsonResult saveUser(@RequestBody User user) throws ServiceException {

        return apiUserService.saveUser(user);
    }

    @ApiOperation(value = "根据用户id删除用户信息")
    @PostMapping("/deleteUserById")
    public JsonResult deleteUserById(@ApiParam(value = "用户id", required = true)
                                     @RequestParam(name = "userId") String userId) throws ServiceException {
        return apiUserService.deleteUserById(userId);
    }

    @ApiOperation(value = "分页查询所有用户信息")
    @GetMapping("/pageUser")
    public JsonResult pageUser(@ApiParam(value = "当前页") @RequestParam(name = "pageNo", required = false)
                                       Integer pageNo,
                               @ApiParam(value = "每页显示几条数据") @RequestParam(name = "pageSize", required = false)
                                       Integer pageSize) {

        return apiUserService.pageUser(pageNo, pageSize);
    }
}
