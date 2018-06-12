package com.modificial.api.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description 配置tkmapper
 */
@Configuration
@AutoConfigureAfter(SqlSessionFactory.class)
public class TkMapperConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.modificial.dao");
        Properties propertiesMapper = new Properties();
        //通用mapper位置，不要和其他mapper、dao放在同一个目录
        propertiesMapper.setProperty("mappers", "com.modificial.mapper.MyMapper");
        propertiesMapper.setProperty("notEmpty", "false");
        //主键UUID回写方法执行顺序,默认AFTER,可选值为(BEFORE|AFTER)
        propertiesMapper.setProperty("ORDER","BEFORE");
        propertiesMapper.setProperty("IDENTITY","SELECT UPPER(REPLACE(uuid(),\"-\",\"\"))");
        mapperScannerConfigurer.setProperties(propertiesMapper);
        return mapperScannerConfigurer;
    }

}
