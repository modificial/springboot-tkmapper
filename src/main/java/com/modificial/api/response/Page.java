package com.modificial.api.response;

import lombok.Data;
import lombok.ToString;

import java.util.Collection;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description
 */
@Data
@ToString
public class Page<T> {
    /**
     * 信息集合
     */
    private Collection<T> collection;
    /**
     * 总条数
     */
    private long count;
}
