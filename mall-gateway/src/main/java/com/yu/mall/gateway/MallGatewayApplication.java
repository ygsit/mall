package com.yu.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//依赖了mall-common模块，引入了MyBatis相关操作，有了数据源之间的相关配置，网关服务不需要数据库配置，需要排除掉
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class, args);
    }

}
