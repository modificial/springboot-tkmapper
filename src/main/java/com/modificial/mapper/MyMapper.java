package com.modificial.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author modificial
 * @date 2018/6/11
 * @company codingApi
 * @description
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
