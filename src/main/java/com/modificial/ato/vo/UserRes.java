package com.modificial.ato.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description
 */
@Data
@ToString
public class UserRes {
    @ApiModelProperty(value = "用户id")
    private  String id;
    @ApiModelProperty(value = "用户名字")
    private  String name;
    @ApiModelProperty(value = "用户地址")
    private  String address;
    @ApiModelProperty(value = "用户年龄")
    private  Integer age;
}
