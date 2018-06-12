package com.modificial.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author modificial
 * @date 2018/5/19
 * @company codingApi
 * @description 用户实体类
 */
@Data
@ApiModel
@ToString
@Table(name = "user")
public class User {
@ApiModelProperty(value = "id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
@ApiModelProperty(value = "用户名")
    private String  name;
@ApiModelProperty(value = "年龄")
    private int age;
@ApiModelProperty(value = "地址")
    private String address;
}
