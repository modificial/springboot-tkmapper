package com.modificial.api.anoncation;

import org.springframework.stereotype.Component;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description mq层定义注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ApiService {
    String value() default "";
}
