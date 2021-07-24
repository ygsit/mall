package com.yu.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *想要远程调用别的服务
 * 	1）、引入open-feign
 * 	2）、编写一个接口，放在feign包下
 * 		2.1、使用@FeignClient注解，并指定调用的服务名
 *    	2.2、声明接口的方法与调用远程服务的请求保持一致
 * 	3）、application类中开启远程调用功能，并扫描feign包(或者feign包下的接口使用@Component注解)
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.yu.mall.member.feign") //开启feign支持
public class MallMemeberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallMemeberApplication.class, args);
	}

}
