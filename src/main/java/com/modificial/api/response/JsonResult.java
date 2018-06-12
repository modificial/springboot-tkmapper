package com.modificial.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author modificial
 * @date 2018/5/19
 * @company codingApi
 * @description
 */
@Data
@ToString
@AllArgsConstructor
public class JsonResult {

    private String status;

    private Object result;
    public  JsonResult(String status){
        this.status=status;
    }

}
