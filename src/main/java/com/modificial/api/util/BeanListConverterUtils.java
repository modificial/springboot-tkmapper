package com.modificial.api.util;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description bean集合相互转换 需改造
 */
@Deprecated
public class BeanListConverterUtils {
    //todo 无法转换
    public static void convert(List<Object> source, List<Object>target){
        if(source==null||source.isEmpty()){
            throw new IllegalArgumentException("原集合不能为空");
        }
        else if(target==null||target.isEmpty()){
            throw new IllegalArgumentException("目标集合不能为空");
        }
        for (Object it : source) {
            Object obj = new Object();
            BeanUtils.copyProperties(it, obj);
            target.add(obj);
        }
    }
}
