package com.yu.mall.thirdparty.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
public class OssConfig {
    @Value("${spring.cloud.alicloud.oss.endpoint}")
    String endpoint;

    @Value("${spring.cloud.alicloud.oss.bucket}")
    String bucket;

    @Value("${spring.cloud.alicloud.access-key}")
    String accessId;

    @Value("${spring.cloud.alicloud.secret-key}")
    String accessKey;

    /*@Bean
    @Scope("prototype")
    public OSS ossClient() {
        return new OSSClientBuilder().build(endpoint, accessId, accessKey);
    }*/
}
